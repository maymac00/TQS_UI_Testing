Feature: cookies
  Background:
    Given I opened the browser at Springfield page

  Scenario: accept all cookies
    When I accept all cookies
    Then cookie number is '48'

  Scenario: accept some cookies
    When I accept some cookies
    Then cookie number is '31'

  Scenario: go to config and select all
    When go to select cookies and select all
    Then cookie number is '28'
