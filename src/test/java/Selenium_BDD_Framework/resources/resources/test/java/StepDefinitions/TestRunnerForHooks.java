package Selenium_BDD_Framework.resources.resources.test.java.StepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/HooksDemo/HooksDemo.feature", glue= {"StepsForHooks"},
monochrome= true,
plugin = {"pretty", "junit:target/JUnitReports/report.xml",
		"json:target/JSONReports/report.json",
		"html:target/HtmlReports"}
		)
public class TestRunnerForHooks {

}