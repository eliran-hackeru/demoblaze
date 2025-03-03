Feature: DemoBlaze Sign Up
  @SignUp
  Scenario Outline: User successfully sign up to the website
    Given the user is on the home page and clicked the Sign Up button
    When the user enters new valid credentials
    Then the user would get a sign up successful message