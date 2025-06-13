package Java_Examples.AutoDesignPattern.SingletonPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    private static volatile WebDriverManager instance;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private WebDriverManager() {
    }

    public static WebDriverManager getInstance(String browser) {
        if (instance == null) {
            synchronized (WebDriverManager.class) {
                if (instance == null) {
                    instance = new WebDriverManager();
                }
            }
        }
        if (tlDriver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    private void initDriver(String browser) {
        switch (browser) {
            case "Chrome":
                tlDriver.set(new ChromeDriver());
                break;

            case "fireFox":
                tlDriver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Incorrect browser name" + browser);
        }
    }

    public WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quiteBrowser() {
        if (tlDriver != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
