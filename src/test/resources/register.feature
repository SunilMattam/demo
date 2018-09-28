Feature: Register
  As a end user
  I want to register to site
  So that i can login into system

  @register
  Scenario: Register
    When I provide email register details as below:
      | gender | fitst_name | last_name | email  | password  | confirm_passowd |
      | Male   | rakesh     | reddddddd | random | East12345 | East12345       |
