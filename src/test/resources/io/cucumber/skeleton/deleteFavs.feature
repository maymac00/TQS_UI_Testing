Feature: add a few products to favorites and then delete them. Check the number of favs is correct
  Background:
    Given I opened the browser at Springfield page
    And I are user
  Scenario: delete what you have
    When I make login with correct user and password
    And I add '2' product from 'tanga' to favorites
    And I delete '2' favorites
    Then there are '0' items in favorites

  Scenario: delete more than we have
    When I make login with correct user and password
    And I add '2' product from 'tanga' to favorites
    And I delete '3' favorites
    Then there are '0' items in favorites

  Scenario: delete less than you have
    When I make login with correct user and password
    And I add '2' product from 'tanga' to favorites
    And I delete '1' favorites
    Then there are '1' items in favorites
