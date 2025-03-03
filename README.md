# UI Automation Testing Project - DemoBlaze
## Overview
This project is an automated UI testing framework using Selenium WebDriver and Cucumber to validate the core functionalities of an e-commerce website.
## Test Scenarios
The project includes the following test scenarios:
1. **Login Tests** - Verifies that users can successfully log in with valid credentials.
2. **Navigation Tests** - Ensure that users can navigate through different product categories.
3. **Cart Tests** - Tests the ability to add and remove items from the shopping cart.
4. **Checkout Tests** - Confirms that users can successfully complete the checkout process.
## Installation & Setup
### Prerequisites
* **Java** (JDK 8+)
* **Maven** (for dependency management)
* **Google Chrome** (for testing in Chrome)
* **ChromeDriver** (Ensure it's compatible with your Chrome version)
### Clone the Repository
```
git clone <repository_url>
cd <repository_folder>
```
### Install Dependencies
```
mvn clean install -DskipTests
```
## Running the Tests
```
mvn test
```
### Run the tests without Maven:
- Run the file:
```
src/test/java/runners/TestRunner.java
```
## Viewing Test Reports
After running the tests, you can access the Cucumber HTML report:
1. Open the following file in your browser:
```
target/cucumber-reports.html
```
2. The report provides a detailed breakdown of test execution, including passed, failed, and skipped steps.
## Project Structure
```
📦 src
 ┣ 📂 main/java
 ┃ ┗ 📂 pages   # Page Object Model (POM) classes
 ┣ 📂 test/java
 ┃ ┣ 📂 stepDefinitions  # Cucumber step definitions
 ┃ ┣ 📂 features         # Feature files written in Gherkin
 ┃ ┗ 📂 runners         # Test runner classes
 ┗ pom.xml              # Maven configuration file
```
## Resources
All the resources can be found at:
```
src/main/resources
```
1. chromedriver.exe - The WebDriver for the tests
2. application.properties - Holds The Base URL for the tests
3. userCredentials.xml - Holds The User Credentials, such as name and password, for the tests.
## Technologies Used
* Selenium WebDriver – For UI automation
* Cucumber – For behavior-driven development (BDD)
* Maven – For dependency management and running the code
## License
This project is licensed under the MIT License.

-------------------------------------------------------
Happy Testing! 🚀
