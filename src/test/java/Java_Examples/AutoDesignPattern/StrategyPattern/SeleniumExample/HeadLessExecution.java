package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessExecution implements TestExecutionStrategy {
    @Override
    public WebDriver setDriver(String browserName) {
        return switch (browserName.toLowerCase().trim()) {
            case "chrome" -> new ChromeDriver((new ChromeOptions()).addArguments("--headless"));
            case "firefox" -> new FirefoxDriver((new FirefoxOptions()).addArguments("--headless"));
            case "edge" -> new EdgeDriver((new EdgeOptions()).addArguments("--headless"));
            default -> throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase().trim());
        };
    }
}
