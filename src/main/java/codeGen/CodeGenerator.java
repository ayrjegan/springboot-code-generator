package codeGen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CodeGenerator {
	public static void main(String[] args) {
		String fileName = "template.txt";
		String className = "Employee";
		
		File inputFile = new File(fileName);
		
		StringBuffer strBuf = new StringBuffer();
		
		try(Scanner reader = new Scanner(inputFile)) {
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				
				strBuf.append(
						line.replaceAll("<Template>", className).replaceAll("<template>", className.toLowerCase()));
				strBuf.append(System.lineSeparator());

			}
			System.out.println(strBuf.toString());
			
			Files.deleteIfExists(Paths.get("templateOut.txt"));
			Files.write(Paths.get("templateOut.txt"), strBuf.toString().getBytes());
			
			File tempFile = new File("templateOut.txt");
			String javaFileName = "";
			
			StringBuffer tempBuf = new StringBuffer();
			Scanner tempReader = new Scanner(tempFile);
			
			while (tempReader.hasNextLine()) {
				String line = tempReader.nextLine();
				System.out.println(line);
				tempBuf.append(line);
				tempBuf.append(System.lineSeparator());
				if(line.contains(".java")) {
					javaFileName=line.replaceAll("#", "").trim();
				}
				if(line.startsWith("############################################################")) {
					Files.deleteIfExists(Paths.get(javaFileName));
					Files.write(Paths.get(javaFileName), tempBuf.toString().getBytes());
					tempBuf=new StringBuffer();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
