@tag
Feature: Login with positive value
  I want to use this template for my feature file
	
  @tag2
  Scenario Outline: Positive test of Login page
    Given I landed in login page
    When Logged in with correct username <username> and password <password>
    Then page redirection and logout button is visible

    Examples: 
      | username     | password               |
      | tomsmith     | SuperSecretPassword!   |
 
