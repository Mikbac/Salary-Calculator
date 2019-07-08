[![Build Status](https://travis-ci.org/Mikbac/Salary-Calculator.svg?branch=master)](https://travis-ci.org/Mikbac/Salary-Calculator)

# Salary Calculator

The application converts salary to PLN.

## Getting Started

### Adding a new countryModel

* You can use POST in swagger.

```
http://localhost:8080/swagger-ui.html#/
```

* Or add countries to the `import.sql` file before run the application.

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
    java -jar artifact-1.0-SNAPSHOT.war
```

Open the browser and hit 
```
http://localhost:8080/countryModel
```

## API Endpoint
|Endpoints|Usage|Params|
|---|---|---|
|```GET /salary-calculator/countries```|Get all of the countries available for the app.||
|```POST /salary-calculator/countryModel```|Add a new countryModel.|**countryCode** - [String] <br>**tax** - [BigDecimal] <br>**fixedCosts** - [BigDecimal] <br>**currencyCode** - [String]|
|```GET /salary-calculator/countryModel/{countryCode}/salary/{valueFromClient}/salaryPLN```|Calculate salary.|**{countryCode}** - Country code <br>**{valueFromClient}** - Salary|

## Server

### Built With

* [JDK 8](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot](https://spring.io/projects/spring-boot) 

* [Maven](https://maven.apache.org/)

* [HSQLDB](http://hsqldb.org/)

* [JUnit 5](https://junit.org/junit5/)

The server uses the [NBP Web API](http://api.nbp.pl/) . 


## Client

### Built With

* [HTML]()

* [CSS]()

* [AngularJS](https://angularjs.org/) 

## Example of features

![ex1](img/ex1.png)
