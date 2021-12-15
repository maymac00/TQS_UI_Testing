Feature: Make login in the web H&M

  Background:
    Given I are user
    And I opened the browser at Springfield page

  Scenario: Do login with a wrong user
    When I make login with incorrect user
    Then the login is not successfull

  Scenario: Do login with a wrong password
    When I make login with incorrect password
    Then the login is not successfull

  # Scenario: Do login with a existing user
    # When I make login with correct user and password
    # Then the login is successfull
