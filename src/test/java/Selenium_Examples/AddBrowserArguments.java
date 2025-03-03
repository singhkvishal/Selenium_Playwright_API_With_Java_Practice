package Selenium_Examples;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class AddBrowserArguments {
    @Test
    public void Test1() {
        //System.setProperty("webdriver.chrome.driver", chromedriverPath);
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("headless");
        options.addArguments("--start-maximized");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("--incognito");
        options.addArguments("test-type");
        options.addArguments("--ignore-certificate-errors");

        // we can set multiple arguments
        //options.addArguments("--start-maximized", "--headless", "--window-size=2560,1440","--ignore-certificate-errors","--disable-extensions","--disable-dev-shm-usage");
        //options.addArguments("--log-level=3");

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);//PageLoadStrategy.NORMAL/NONE
        //options.setCapability("proxy","Proxy");
        //options.addExtensions(new File("Path to CRX File"));

        WebDriver driver = new ChromeDriver(options);
        //driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        driver.get("https://example.com/");
    }

    @Test
    public void Test2() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://developer.chrome.com/docs/chromedriver/capabilities");
        driver.manage().window().maximize();
    }
}
