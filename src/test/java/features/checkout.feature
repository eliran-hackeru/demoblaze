Feature: DemoBlaze Shopping Site Checkout Process Functionality

Scenario: Checkout Process
  Given the user has items in their cart
  When they go to checkout
  And they enter valid payment and shipping details
  Then the order should be successfully placed

Scenario: Checkout with an Empty Cart
  Given the user has an empty cart
  When they try to proceed to checkout
  Then they should see a message preventing checkout