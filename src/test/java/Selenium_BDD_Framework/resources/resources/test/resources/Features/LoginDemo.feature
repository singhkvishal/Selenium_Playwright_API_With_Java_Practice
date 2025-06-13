Feature: Test login functionality

  Background:

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And Validate user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then Validate user is navigated to the home page

    Examples: 
      | username | password |
      | Raghav   |    12345 |
      | Ele      |    12345 |
