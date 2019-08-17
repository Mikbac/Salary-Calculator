[![Build Status](https://travis-ci.org/Mikbac/Salary-Calculator.svg?branch=master)](https://travis-ci.org/Mikbac/Salary-Calculator)

# Salary Calculator

The application converts salary to PLN.

# Table of contents
* [Adding the new country](#adding-the-new-country)
* [Added countries](#added-countries)
* [Prerequisites](#prerequisites)
* [Installing](#installing)
* [API Endpoint](#api-endpoint)
* [Built with](#built-with)

## Getting Started

### Adding the new country

* You can use POST in swagger.

```
http://localhost:8080/swagger-ui.html#/
```

* Or add countries to the `import.sql` file before running the application.

### Added countries

* United Kingdom - ```UK```
* Germany - ```DE```
* Poland - ```PL```


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
http://localhost:8080/
```

## API Endpoint
|Endpoints|Usage|Params|
|---|---|---|
|```GET /salary-calculator/countries```|Get all of the countries available for the app.||
|```POST /salary-calculator/countryModel```|Add a new countryModel.|**countryCode** - [String] <br>**tax** - [BigDecimal] <br>**fixedCosts** - [BigDecimal] <br>**currencyCode** - [String]|
|```GET /salary-calculator/countryModel/{countryCode}/salary/{salaryFromClient}/salaryPLN```|Calculate salary.|**{countryCode}** - Country code <br>**{salaryFromClient}** - Salary|


## Built with

* [JDK 8](https://www.oracle.com/technetwork/java/index.html)

* [Spring Boot](https://spring.io/projects/spring-boot) 

* [Maven](https://maven.apache.org/)

* [HSQLDB](http://hsqldb.org/)

* [JUnit 5](https://junit.org/junit5/)

* [HTML]()

* [CSS]()

* [AngularJS](https://angularjs.org/) 

The application uses the [NBP Web API](http://api.nbp.pl/). 

## Example of features

![ex1](img/ex1.png)
