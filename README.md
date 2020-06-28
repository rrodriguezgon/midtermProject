![IronHack Logo](https://s3-eu-west-1.amazonaws.com/ih-materials/uploads/upload_d5c5793015fec3be28a63c4fa3dd4d55.png)

# midtermProject
<p align="center"><strong> Raquel Rodriguez</strong></p>


* [Tools](#tools)

* [How it works](#how-it-works)

* [Documentation](#documentation)

* [Test Coverage](#test-coverage)

## <a name="tools"></a>Tools
- IntelliJ (Compile and run Java Program, JDK 11)
- Spring Boot Dependencies (Spring Boot DevTools, Mysql Driver, Spring Data JPA, Spring Web,log4j-core, log4j-nosql,mongo-java-driver)
- MySQL
- Postman
- Swagger (API Document with HTML)

## <a name="how-it-works"></a>How it works
<p align="center"><strong> Disclaimer: Any doubts on what commands to write consult the Documentation section below. </strong></p>

1. Clone the **midtermProject** repository on your local computer.

2. Access the folder **"midtermProject"** in your IntelliJ.

3. Go into your MySQL Workbench and type the following commands ```CREATE SCHEMA midtermProject```, ```CREATE SCHEMA midtermProject_test```
4. Type the command ```mvn spring-boot:run``` in the terminal of your IntelliJ.
                                  
 5. Open the **Postman** in your terminal and then you can start making requests. 
 The requests allows you to CRUD (**create, read, update and delete**) all entities you desire.
 
 * **JavaDOC**: The documentation for all methods from the Java program is available in this GitHub Repository by entering the following link (https://github.com/k823/Teen-TiTenX-CRM-3/tree/master/Documentation).
 
 * **Postman**: Import Collection_midterm.json and Environment_testVariables.json.
 
 * **Swagger**:The documentation for all requests is available in [Swagger](http://localhost:8080/swagger-ui.html) by entering the following link (http://localhost:8080/swagger-ui.html) while having the program rolling in the terminal.
 
 1. When you enter [THIS LINK](http://localhost:8080/swagger-ui.html) you'll find the following configuration, where all models specifications are displayed and the routes of the requests with their own specifications as well.
  
 ## <a name="test-coverage"></a>Test Coverage
* In the **Java Program** in IntelliJ our test coverage is **100% for classes**, **100% for methods** and **100% for lines**.