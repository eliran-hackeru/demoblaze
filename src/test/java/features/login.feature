Feature: DemoBlaze Login
  @Login
  Scenario Outline: User successfully logins to the website
    Given the user is on the home page and clicked the Login button
    When the user enters valid credentials
    Then the user name should be appeared on the page header