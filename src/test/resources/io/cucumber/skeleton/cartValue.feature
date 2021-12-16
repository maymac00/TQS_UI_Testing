#FEATURES CON MINIMO 3 ESCENARIOS CADA UNO
# 1.sistema de autenticación -- “Log‐in with a wrong user”,“Log‐in with a wrong password”,“Log‐in with a existing user”
# 2.crear un usuario
# 3.añadir productos a un carrito
# 4.sistema de búsqueda
# ...

Feature: check value of cart is correct
  Scenario: buy a few products and check if cart value is correct
    Given I opened the browser at Springfield page
    When I buy '3' first products from 'calzoncillos'
    Then the shopping cart value is '73.96'

  Scenario: buy a few products and check if cart value is correct
    Given I opened the browser at Springfield page
    When I buy '2' first products from 'bragas'
    Then the shopping cart value is '41.97'

  Scenario: buy a few products and check if cart value is correct
    Given I opened the browser at Springfield page
    When I buy '1' first products from 'calcetines'
    Then the shopping cart value is not '41.97'
