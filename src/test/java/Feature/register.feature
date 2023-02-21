Feature: register functionality test

  Scenario: register to a website with valid values
    Given browser is open And user is on registration page
    And user enters values
    And click on register button
    Then message displayed login successfully

  Scenario: Values not pass to the mandatory feild
    Given browser is open And user is on registration page
    And user enters some values
    And click on register button
    Then display message "feild is reqired"

  Scenario: Password and confirmed password is not same
    Given browser is open And user is on registration page
    And user enters values and different password
    And click on register button
    Then message displayed "Password not match"

  Scenario: User register with existing username
    Given browser is open And user is on registration page
    And user enters values and existing username
    And click on register button
    Then message is displayed "This username already exist"

   Scenario: firstName, lastName, address, city, state contains only alphabet and zipcode, phoneNo, ssn contains only numbers 
    Given browser is open And user is on registration page
    And user enters alphanumeric values
    And click on register button
    Then message is display "Please enter valid details"
 
   Scenario Outline: Phone number can not contains less than or more than ten digits and it not be a alphanumeric 
    Given browser is open And user is on registration page
    And user enters <phoneno> and <username> and <password>
    And click on register button
    Then message is display "Please enter valid details"
  
  Examples: 
  	|phoneno     |username |password |
  	|12345       |roshani6 |123456   |
  	|123456789012|roshani7 |123456   |
  	|123fdfdg    |roshani8 |123456   |
