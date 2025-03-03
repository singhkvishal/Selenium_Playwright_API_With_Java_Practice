package Java_Examples.AutoDesignPattern.FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager implements BrowserDriver{

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
