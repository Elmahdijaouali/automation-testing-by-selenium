# Automation Testing by Selenium

This project is focused on **automating tests** for a Java web application using **Selenium WebDriver** and **JUnit 5**. It includes test cases for importing data, generating timetables, and exporting schedules.

---

## Features

- Automated test cases for:
    - Importing Excel data for rooms, schedules, and programs
    - Generating timetables for groups and instructors
    - Exporting schedules in various formats
- Tests are organized in **JUnit 5 test suites** for running in a specific order
- Supports running tests **locally** with Maven

---

## Project Structure

src/

├─ main/java # Application main code (if any)

└─ test/java # Automated test cases

├─ config # Test configuration and suites

├─ exceportationDesEmplois

├─ generationEmploisDuTemps

└─ importationDataFromExcel
datatest/ # Test Excel files for import tests

pom.xml # Maven project configuration



---

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- Google Chrome (for Selenium tests)
- ChromeDriver compatible with your Chrome version

---

## Running Tests Locally

1. Clone the repository:
   ````
   git clone https://github.com/Elmahdijaouali/automation-testing-by-selenium.git
   cd automation-testing-by-selenium


## Run a specific test suite:

  ````
    mvn clean test -Dtest=config.PrimaryTestSuiteTest

