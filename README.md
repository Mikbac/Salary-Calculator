[![Build Status](https://travis-ci.org/Mikbac/zadanie_kalkulator_s.svg?branch=master)](https://travis-ci.org/Mikbac/zadanie_kalkulator_s)

# zadanie_kalkulator_s

The application converts salary to PLN.

## Getting Started

### Add new countries

* You can use POST in swagger.

```
http://localhost:8080/swagger-ui.html#/
```

* Or add countries to `CommandLineRunner` in `SpringBootWebApplication` before run the application.

### Added countries

* UK
* DE
* PL


### Prerequisites

* Maven
* JDK 8


### Installing
```
    mvn install
```
```
    cd target
```
```    
    java -jar artifact-1.0-SNAPSHOT.jar
```

Open the browser and hit 
```
http://localhost:8080/country
```

## Server

### Built With

* [JDK 8](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot](https://spring.io/projects/spring-boot) 

* [Maven](https://maven.apache.org/)

* [HSQLDB](http://hsqldb.org/)

* [JUnit 5](https://junit.org/junit5/)


## Client

### Built With

* [HTML]()

* [CSS]()

* [AngularJS](https://angularjs.org/) 