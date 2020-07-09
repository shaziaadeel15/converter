# Unit Conversion Testing System

Application to test unit conversion, two types of systems are currently supported

- Temperature
- Volume

Supported temperature units are Kelvin, Celsius, Fahrenheit, and Rankine
Supported volumes units are liters, tablespoons, cubic-inches, cups, cubic-feet, and gallons

### Prerequisites

Make sure java and maven is installed on your system

## Getting Start

- Download source code.
- Got to converter main folder
- Run following command to clean and build the project

```
mvn clean package
```

- Run following command to run application server

```
java -jar target/spring-boot-web.jar
```

- Now go to browser and type following url to start application

```
http://localhost:8080/
```

## Description

The application act in both mode

- User can enter data manually in fields
- There is also bulk data loading option. Here user can select a CSV file to bulk enter the data. After loading can use "Check Data" button foor checking the results
- Before doing comparision of result computed by application and result enter values are round to tenths place. Also application can accept answer if there is error of 0.1 in calculation

## Future Enhancements

- Currently application is accepting two systems, in future can add more unit systems.
- Bulk loading is accepting CSV file, in future can add support of Excel sheets, JSON format files.
- More validity checks can be implemented at GUI level.
