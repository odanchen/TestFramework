# Web Test Automation Framework

A lightweight and modular Web Test Automation Framework built to gain hands-on experience in automated UI testing. The framework follows a layered architecture and leverages industry-standard tools and best practices for efficient and maintainable test automation.

## Features
* **Layered Test Automation Architecture** for better separation of concerns
* **Page Object Model (POM)** for scalable and maintainable test scripts
* **Reusable Utilities** for logging, waiting mechanisms, and screenshot capturing
* **Parameterized Test Execution** using **TestNG**
* **Cross-Browser Support** using WebDriver Manager
* **Design Patterns & SOLID Principles** for robust test implementation

## Framework Architecture
The framework is structured into multiple layers to ensure modularity and maintainability:

* **Test Layer**:
Contains test cases and scenarios that drive the test execution.

* **Test Data Layer**:
Manages input values and expected results for test cases.

* **Page Object Layer**:
Implements the Page Object Model (POM) to encapsulate UI elements and user interactions.

* **Step Definitions Layer**:
Defines reusable test steps to enhance readability and maintainability.

* **Utility Layer**
Provides helper methods such as logging, explicit waits, and screenshot capturing.

## Tech Stack & Dependencies
The framework is built using the following technologies:

* **Java 11** – The programming language of choice
* **Selenium WebDriver** – For browser automation
* **TestNG** – For test execution and reporting
* **Gradle** – For build automation
* **Log4j** – For logging and debugging
* **Owner (Aeonbits)** – For configuration management
* **WebDriver Manager (Bonigarcia)** – For automatic browser driver setup
* **AssertJ** – For fluent assertions

## Design Patterns Implemented
This framework follows several well-known design patterns to ensure maintainability and scalability:

* **Page Object Model (POM)** – Encapsulates page elements and actions
* **Fluent Interface** – Improves readability and chaining of methods
* **Singleton** – Ensures a single instance of critical components
* **Curiously Recurring Template Pattern (CRTP)** – Enhances type safety and reusability

Additionally, the framework follows SOLID principles to maintain clean, extensible, and scalable code.
## Getting Started

### Prerequisites
Ensure you have the following installed on your system:

* Java 11+
* Gradle
* Chrome or Firefox browsers

### Installation
Clone the repository:

```bash
git clone https://github.com/odanchen/TestFramework.git
cd TestFramework
```
### Running Tests
To execute tests, run:

```bash
gradle test
```


### Reporting
Test execution results, logs, and screenshots can be found in the `build/logs` directory.

## Contributing
Contributions, issues, and feature requests are welcome! Feel free to fork the repository and submit a pull request.
