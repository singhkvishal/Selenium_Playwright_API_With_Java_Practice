package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverContext {
    private  TestExecutionStrategy testExecutionStrategy;

    public DriverContext(TestExecutionStrategy testExecutionStrategy){
        this.testExecutionStrategy=testExecutionStrategy;
    }
    //setter

    public  void setTestExecutionStrategy(TestExecutionStrategy testExecutionStrategy){
        this.testExecutionStrategy=testExecutionStrategy;
    }

    public WebDriver getDriver(String browserName) throws MalformedURLException {
        return testExecutionStrategy.setDriver(browserName);
    }
}
