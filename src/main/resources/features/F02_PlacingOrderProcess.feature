@smoke
Feature: Placing Order
  Scenario: User Can Purchase an Item Successfully
    Given User Logged In
    When User Adds An Item To Cart
    And User Opens The Cart
    And User Clicks Checkout
    And User Fill In The Checkout Info
    And User Confirm the Order
    Then The Order is Created Successfully
    And UserLogout
