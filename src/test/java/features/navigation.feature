Feature: DemoBlaze Navigation

  @Navigation
  Scenario Outline: User navigates through the website
    Given the user is on the home page
    When the user navigates to "<category>" category
    Then the user should see the "<category>" products

    Examples:
      | category  |
      | Phones    |
      | Laptops   |
      | Monitors  |