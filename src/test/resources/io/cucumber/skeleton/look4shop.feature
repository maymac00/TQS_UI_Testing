Feature: Make login in the web H&M
  Background:
    Given I opened the browser at Springfield page

  Scenario: look for a shop in sabadell and find it
    When look for a shop in 'Sabadell'
    Then 'Sabadell (Barcelona) (1)' is found

  Scenario: look for a shop in Salamanca, dont find expected
    When look for a shop in 'Salamanca'
    Then 'Sabadell (Barcelona) (1)' is not found

  Scenario: look for a invented city
    When look for a shop in 'Metaverse'
    Then 'Sabadell (Barcelona) (1)' is not found
