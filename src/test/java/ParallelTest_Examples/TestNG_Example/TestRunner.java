package ParallelTest_Examples.TestNG_Example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/SecondTestSenarioOutline.feature/",
        tags = "@Sanity",plugin = {"pretty","html:target/cucumber-html-report","json:target/cucumber.json","junit:target/cucumber.xml"},
        glue = {"com.learn"}
)
public class TestRunner {
    @BeforeAll
    public void BeforeAll(){

    }
}
