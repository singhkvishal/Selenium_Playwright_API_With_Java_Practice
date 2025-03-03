package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalExecutionStrategy implements TestExecutionStrategy{

    @Override
    public WebDriver setDriver(String browserName) {
       return switch (browserName.toLowerCase().trim()){
            case "chrome"->new ChromeDriver();
            case "firefox"->new FirefoxDriver();
            case "edge"->new EdgeDriver();
           default -> throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase().trim());
       };
    }
}
