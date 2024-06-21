package Java_Web_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TableExamples {
    WebDriver driver;

    @BeforeSuite
    public void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
    }
    @Test
    public void TestSumOfRows(){

    }
}
