#FEATURES CON MINIMO 3 ESCENARIOS CADA UNO
# 1.sistema de autenticación -- “Log‐in with a wrong user”,“Log‐in with a wrong password”,“Log‐in with a existing user”
# 2.crear un usuario
# 3.añadir productos a un carrito
# 4.sistema de búsqueda
# ...

Feature: in any page we can return home
  Scenario: we are in products page
    Given I opened the browser at Springfield page
    When I go to menu item '0'
    And i go home
    Then we are in home page

  Scenario: we are in products page
    Given I opened the browser at Springfield page
    When I go to menu item '1'
    And i go home
    Then we are in home page

  Scenario: we are in products page
    Given I opened the browser at Springfield page
    When I go to menu item '2'
    And i go home
    Then we are in home page

  Scenario: we are in products page
    Given I opened the browser at Springfield page
    When I go to menu item '3'
    And i go home
    Then we are in home page