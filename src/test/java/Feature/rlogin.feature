Feature: login functionality test

	
  Scenario Outline: Check login with valid credentials
    Given browser is open
    When user enters valid <username> and <password>
    And clicks on login button
    Then user is navigated to the home page
    
   Examples:
   |username |password |
   |roshaniborase |1234|
   
   
    Scenario Outline: Check login with invalid credentials
    Given browser is open
    When user enters invalid <username> and <password>
    And clicks on login button
    Then user get a message "invalid credentials"
    
   Examples:
   |username |password |
   |roshani1 |roshani123|
 
    Scenario Outline: Check login with existing credentials
    Given browser is open
    When user enters existing values <username> and <password> 
    And clicks on login button
    Then user navigate to home page
    
   Examples:
   |username |password |
   |roshaniborase |1234| 
   