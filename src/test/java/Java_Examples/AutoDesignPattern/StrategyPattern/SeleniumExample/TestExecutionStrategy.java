package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface TestExecutionStrategy {
    WebDriver setDriver(String browserName) throws MalformedURLException;
}
