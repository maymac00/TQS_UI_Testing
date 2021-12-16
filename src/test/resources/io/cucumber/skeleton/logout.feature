
Feature: Logout
  Background:
    Given I are user
    And I opened the browser at Springfield page

  Scenario: Do login with a existing user
    When I make login with correct user and password
    Then the login is successfull
    When I logout
    Then im not logged

  Scenario: Do logout without logging in
    When I logout
    Then im already out

