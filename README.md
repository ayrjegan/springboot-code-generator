# Code Generator
A Java standalone application with Maven build

## What is this?
This project helps in generating the Service, ServiceImpl, Controller and Repository classes for a given entity class.

- template.txt contains the template code. You can extend this as per your class generation needs
- The code reads the template, replace the <Template> or <template> tags
- Stores to a temporary file called templateOut.txt
- Generates the .java code


## Build
Checkout the project and build it using maven.



Inside the root directory of the project type the following:

Updte the Entity class name in CodeGenerator.java for which you want to generate code.
For example: 
```
String className = "Employee";
```

Build

```
./mvn clean install
```

If this was successful you should see something like:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```

Now run the application by typing:

```
java -jar target\CodeGenerator-1.0-SNAPSHOT.jar
```

After running the application, .java files will be generated under the root directory.

```
EmployeeController.java
EmployeeRepository.java
EmployeeService.java
EmployeeServiceImpl.java
templateOut.txt
```
