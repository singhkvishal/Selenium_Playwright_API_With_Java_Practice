package Java_Web_Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    WebDriver driver;

    @BeforeSuite
    public void BeforeSuite() {
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void LaunchURL() {
        driver.get("http://www.google.com");
    }

    @BeforeClass
    public void TestClass() {
        System.out.println("TestClass");
    }

    @BeforeMethod
    public void TestMethod() {
        System.out.println("TestMethod");
    }

    @BeforeGroups
    public void TestGroup() {
        System.out.println("TestGroup");
    }

    @Test
    public void TakePageScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       // String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\test1.png"));
    }

    @Test
    public void TakeWebElementScreenShot() throws IOException {
        File we = driver.findElement(By.xpath("/html/body/div[1]/div[2]")).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(we, new File(System.getProperty("user.dir") + "\\test.png"));
    }
    @Test(priority = 0)
    public void ActionTest1() throws IOException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement webElement = driver.findElement(By.name("my-password"));
        File scrFile = webElement.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + "/test.png");
        FileUtils.copyFile(scrFile, DestFile);
    }
    @AfterSuite
    public void End() {
        driver.close();
    }
}
