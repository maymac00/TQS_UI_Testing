Feature: add a few products to favorites and check the number of favs
  Background:
    Given I opened the browser at Springfield page
    And I are user
  Scenario: correct
    When I make login with correct user and password
    And I add '2' product from 'tanga' to favorites
    Then there are '2' items in favorites

  Scenario: not correct
    When I make login with correct user and password
    And I add '2' product from 'americana' to favorites
    Then there are not '3' items in favorites