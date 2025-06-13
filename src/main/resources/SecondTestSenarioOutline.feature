Feature: First Test scenario Outline Example

  @Regression
  Scenario Outline:  Test the Scenario Outline Example
    Given Launch the Browser
    When Validate the Browser is Launched
    And Enter the User name "<UserName>"
    And Enter the Password "<Pass>"
    Then Click on Login Button
    And Validate the User is login

  Examples:
    |UserName|Pass|
    |Vishal|vishal01|
    |Vishal Singh|Vishalsingh02|
