# -- FILE: features/gherkin.rule_example.feature
Feature: Highlander

  Rule: There can be only One
   Background:
     Given user navigates to the login page by opening Chrome

    Example: Only One -- More than one alive
      And Validate the Page
      When Enter the Business Email ID & Password
      Then Click on Sign me in
      But Validate the Login Page


