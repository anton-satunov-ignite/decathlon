# decathlon-calculator

Use code style from config/codestyle.xml

##### Table of Contents  
**[Prerequisites](#prerequisites)**<br>
**[Project setup](#project-setup)**<br>
**[Running application](#run-locally)**<br>

## Prerequisites
* JDK 11 (OpenJDK)
* You will need to enable Annotation processing for Lombok
```
IntelliJ
Build, Execution, Deployment → Compiler → Annotation Processors
```

## Project setup
Project uses gradle wrapper

### Build
 ```bash
./gradlew clean build
 ```

#### Run all tests
```bash
./gradlew clean check test jacocoTestReport
```

#### Run locally
```bash
./gradlew bootRun
```

* Swagger available at http://localhost:8080/decathlon-calculator/swagger-ui.html