# Unit Conversion Validation System

Application to validate unit conversion. This application currently supports two types of unit systems.

- **Temperature**  
   Units supported for temperature are Kelvin, Celsius, Fahrenheit and Rankine.
  <br/> <br/>
- **Volume**  
  Units supported for volume measurements are liters, tablespoons, cubic-inches, cups, cubic-feet and gallons.

The application is live and deployed on Heroku servers, it's accessible at this [URL](https://converter-ci-cd-process.herokuapp.com/).<br/>
Latest stable version of the application is deployed on [Heroku Servers](https://www.heroku.com/) through the inegration of CI/CD pipeline. The pipeline consists of [GitHub](https://github.com/shaziaadeel15/converter) -> [Travis CI](https://travis-ci.com/) -> [Heroku Web Server](https://converter-ci-cd-process.herokuapp.com/).

### Prerequisites

Make sure Java (v8) and Maven is installed on your system.

## Getting Started

- Download source code.
- Open command promt.
- Loacte downloaded project folder in the machine.
- Run following command to clean and build the project.

```
mvn clean package
```

- Run following command to execute application server

```
java -jar target/spring-boot-web.jar
```

- Now go to browser and type following url to access the application

```
http://localhost:8080/
```

## Description

The web application allows user to enter following 4 values, input measurement value and unit followed by converted value and output unit. <br/>Application performs validation as the user clicks 'Check Data' button.

- User can enter data in input fields.
- User can add multiple rows to be validated in one go.
- Application also alows to bulk upload data. Here user can select a CSV file to bulk enter the data. After uploading the CSV file, user can click "Check Data" button for bulk validation of all the data in one go.
- In order to avoid rounding errors, application is programmed to ignore rounding threshold of 0.1

## Future Enhancements

- Currently application is accepting two systems, in future can add more unit systems.
- Bulk loading is accepting CSV file, in future can add support of Excel sheets, JSON format files.
- Allow rounding threshold to be configurable from GUI.
- More validation checks can be implemented at GUI level.
- For bulk uploading, we can implement better input data validation with detailed reporting on loaction of error in the input file.
