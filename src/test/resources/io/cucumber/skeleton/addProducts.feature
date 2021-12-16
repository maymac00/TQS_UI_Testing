#FEATURES CON MINIMO 3 ESCENARIOS CADA UNO
# 1.sistema de autenticación -- “Log‐in with a wrong user”,“Log‐in with a wrong password”,“Log‐in with a existing user”
# 2.crear un usuario
# 3.añadir productos a un carrito
# 4.sistema de búsqueda
# ...

Feature: add products to a cart
  Scenario: choose a product and it is displayed in the shopping cart successfully
    Given I opened the browser at Springfield page
    When I look for 'Calcetines' and select any displayed result to go to the shopping cart
    Then the shopping cart show the product is not '0'

  Scenario: choose a product and it is displayed in the shopping cart successfully
    Given I opened the browser at Springfield page
    When I look for 'Americanas' and select any displayed result to go to the shopping cart
    Then the shopping cart show the product is not '2'

  Scenario: choose a product and it is displayed in the shopping cart successfully
    Given I opened the browser at Springfield page
    When I look for 'calzoncillos' and select any displayed result to go to the shopping cart
    Then the shopping cart show the product is not '3'

