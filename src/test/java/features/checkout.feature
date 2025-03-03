Feature: DemoBlaze Checkout

Scenario Outline: Complete E2E Checkout Process
  Given the user has items in their cart
  When the user goes to checkout
  And the user enters valid payment and shipping details
  Then the order should be successfully placed