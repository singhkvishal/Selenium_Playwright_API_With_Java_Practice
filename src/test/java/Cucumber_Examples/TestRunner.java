package Cucumber_Examples;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Cucumber_Examples"
        //,glue={"src/test/java/Cucumber_Examples/"}
)
public class TestRunner {
}
