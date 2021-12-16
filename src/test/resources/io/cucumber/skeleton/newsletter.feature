Feature: subscribingg to newsletter
  Scenario: suscribe to newsletter
    Given I opened the browser at Springfield page
    When I go to news letter and i sign up with 'mail5@gmail.com', 'male', pc '08202'
    Then the signup is a success

  Scenario: codi postal no valid
    Given I opened the browser at Springfield page
    When I go to news letter and i sign up with 'mail4@gmail.com', 'female', pc '999999'
    Then the signup is a success

  Scenario: mail que ja esta suscrit
    Given I opened the browser at Springfield page
    When I go to news letter and i sign up with 'mail@gmail.com', 'male', pc '08202'
    Then the signup is a repeated