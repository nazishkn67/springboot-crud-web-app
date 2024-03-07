# Spring Boot CRUD Application

This project contains a web application with simple user interface to manage data effortlessly.
It is built using Spring Boot, Thymeleaf, Spring JPA and MySQL to perform CRUD (Create, Read, Update, Delete) operations following the MVC architecture. 

## Project Structure

```
├─ src/main                          
│   ├─ java/com/example/lab                         
│   │   ├─ controller     
│   │   ├─ model                         
│   │   ├─ repository                      
│   │   ├─ service           
│   │   └─ LabApplication.java                          
│   └─ resources
│       ├─ templates
│       └─ application.yml               
├─ src/test/java              
└─ pom.xml                                     
```

- **controller**, **model**, **repository**, and **service** packages contains controller, entity, repository, service class/interfaces respectively.
- **templates** folder contains html files for home, add, update and view detail pages.
- **application.yml** contains external database and other configuration properties.
- **pom.xml** contains project information such as starter dependencies, plugins, source/test directory, etc.

## Technologies used

```
Language           : Java 17 
Framework          : Spring Boot 3
Project Management : Maven
Database           : MySQL Workbench 8
Template Engine    : Thymeleaf
```

## How to run

1. Configure the database connection using **application.yml**
2. Build the project: `mvn clean install`
3. Run the application: `mvn spring-boot:run`
