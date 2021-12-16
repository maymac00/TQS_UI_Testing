Feature: Getting to client support pages
  Scenario: getting to Entrega
    Given I opened the browser at Springfield page
    When I go to support and i click to 'Entrega'
    Then the url is a correct for 'Entrega'

  Scenario: getting to Pagos
    Given I opened the browser at Springfield page
    When I go to support and i click to 'Pagos'
    Then the url is a correct for 'Pagos'

  Scenario: getting to Devoluciones
    Given I opened the browser at Springfield page
    When I go to support and i click to 'Devoluciones'
    Then the url is a correct for 'Devoluciones'

  Scenario: getting to contacta
    Given I opened the browser at Springfield page
    When I go to support and i click to 'Contacta'
    Then the url is a correct for 'Contacta'

