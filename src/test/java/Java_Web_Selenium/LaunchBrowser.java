package Java_Web_Selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LaunchBrowser {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        //1- Add the Extension on browser
        options.addExtensions(new File("/path/to/extension.crx"));

        //2- Add the Proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");
        options.setCapability("proxy", proxy);

        //3-maximiz the Browser
        options.addArguments("start-maximized");

        //4-Block dialog windows
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        //5- Set the Download Directory
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "/directory/path");
        options.setExperimentalOption("prefs", prefs);

        //6-Accept Insecure Certificate
        options.setAcceptInsecureCerts(true);

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("Sessionkey");

        driver.get("https://expired.badssl.com/");
    }
}
