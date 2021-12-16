#FEATURES CON MINIMO 3 ESCENARIOS CADA UNO
# 1.sistema de autenticación -- “Log‐in with a wrong user”,“Log‐in with a wrong password”,“Log‐in with a existing user”
# 2.crear un usuario
# 3.añadir productos a un carrito
# 4.sistema de búsqueda
# ...
Feature: registra
  Background:
    Given I opened the browser at Springfield page

  Scenario: register a new account
    When I create a new account with mail: 'qwerweweqegsqwer@kamusinav.site' and pass 'Passwd1234'
    Then the register is successfull

  Scenario: register a new account with non valid mail
    When I create a new account with mail: 'qwer' and pass 'Passwd1234'
    Then the register is not successfull

  Scenario: register a new account with non valid passwd
    When I create a new account with mail: 'txhirstiness@virginiaintel.com' and pass 'passwd1234'
    Then the register is not successfull

