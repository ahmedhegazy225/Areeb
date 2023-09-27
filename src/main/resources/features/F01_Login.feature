@smoke
Feature: Login

  Scenario: User Can Login using valid Credentials
    Given User Opens The Login Page
    When User Enters Valid Credentials
    And User Clicks Login
    Then User Login Successfully