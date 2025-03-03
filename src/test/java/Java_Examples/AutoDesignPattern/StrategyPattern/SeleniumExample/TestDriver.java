package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TestDriver {
    public static void main(String[] args) throws MalformedURLException {
        DriverContext driverContext=new DriverContext(new LocalExecutionStrategy());
        WebDriver driver= driverContext.getDriver("chrome");
         driver.get("https://www.google.com");

         driverContext.setTestExecutionStrategy(new HeadLessExecution());
        driver.get("https://www.google.com");
    }
}
