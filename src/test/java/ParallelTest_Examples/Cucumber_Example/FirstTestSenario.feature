Feature: First Test scenario Example

  Background:
    Given Launch the Browser

  @Sanity
  Scenario :  Test the Scenario

    When Validate the Browser is Launched
    And Enter the User name "UserName"
    And Enter the Password "Pass"
    Then Click on Login Button
    And Validate the User is login

