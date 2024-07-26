package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Locators {
    WebDriver driver;

    @BeforeSuite
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void cssSelector() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // 1- Class name-> tagename.classname->button.signIn
        driver.findElement(By.cssSelector("input.form-control")).sendKeys("Test");

        //2-id->tagname#id-> input#inputUsername
        driver.findElement(By.cssSelector("input#my-check-2")).click();

        //3- input[paceholder='usrename']
        driver.findElement(By.cssSelector("input[name='my-password']")).sendKeys("Test");

        //4- nth
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("Test");
    }

    @Test
    public void Xpath() throws InterruptedException {
        //Xpath -index
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("xpath");

        //full Tag name
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("234234324");

        //implicit wait - 2 seconds time out
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Vishal");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        // search by Index
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        //Search by nth-child
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Vishal");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("VishalSingh");
        Thread.sleep(TimeUnit.SECONDS.toSeconds(5));
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
    }

    @AfterSuite
    public void TearDown() {
        driver.close();
    }
}