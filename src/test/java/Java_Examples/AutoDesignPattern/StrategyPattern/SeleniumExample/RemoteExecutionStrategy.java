package Java_Examples.AutoDesignPattern.StrategyPattern.SeleniumExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteExecutionStrategy  implements TestExecutionStrategy {
    @Override
    public WebDriver setDriver(String browserName) throws MalformedURLException {
        WebDriver driver=null;
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                ChromeOptions co = new ChromeOptions();
                co.setCapability("browserName", "chrome");
                driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/bub"), co);
            break;

            case "firefox":
                driver= new FirefoxDriver();
            break;

            case "edge":
                driver= new EdgeDriver();
            break;
        }
        return driver;
    }
}
