package Selenium_BDD_Framework.resources.resources.test.java.StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="/src/test/resources/FeatureWithTags",
glue= {"StepDefinitions"},
tags = "@smoke"

		)
public class TestRunner_RunWithMultipleTags {

}
