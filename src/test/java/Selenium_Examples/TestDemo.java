package Selenium_Examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestDemo {
    WebDriver driver;

    @Test
    public void Setup() throws InterruptedException, IOException {

        ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();//Console output
       // service = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();//Log level
       // service = new ChromeDriverService.Builder().withAppendLog(true).withReadableTimestamp(true).build();//Log file features
       // service = new ChromeDriverService.Builder().withBuildCheckDisabled(true).build();//Disabling build check
        service = new ChromeDriverService.Builder().withLogFile(new File("chromedriver.log")).withLogLevel(ChromiumDriverLogLevel.INFO).build();

        driver = new ChromeDriver(service);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
        File logLocation = getTempFile("logsWithLevel", ".log");
        String fileContent = new String(Files.readAllBytes(logLocation.toPath()));

        Assert.assertTrue(fileContent.contains("Starting ChromeDriver"));
    }


    protected File getTempFile(String prefix, String suffix) {
        File logLocation = null;
        try {
            logLocation = File.createTempFile(prefix, suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logLocation.deleteOnExit();

        return logLocation;
    }
}
