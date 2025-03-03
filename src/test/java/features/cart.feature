Feature: Add & Remove Item from Cart

  Scenario Outline: User adds and removes an item from the cart
    Given the user has entered the home page
    And the user adds a product to the cart
    When the user goes to the cart
    And the cart contains the product
    And the user removes the product from the cart
    Then the cart would be empty