Feature: DemoBlaze Shopping Site Session Functionality

Scenario: User Registration
    Given the user is on the home page and clicked the Sign-Up button
    When they enter valid details and submit the form
    Then an account should be created successfully
    And the user should see a confirmation message

Scenario: Successful login
    Given the user is on the home page and clicked the Login button
    When the user enters valid credentials
    Then the user name should be appeared on the page header