package Java_Examples.AutoDesignPattern.FactoryPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;
    @BeforeTest
    public void Setup(){
        driver= DriverFactory.getDriver("chrome").createDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    }

    @Test
    public void TitleTest(){
       Assert.assertEquals(driver.getTitle(),"Account Login");
    }

    @Test
    public void loginTest(){
       driver.findElement(By.name("email")).sendKeys("test@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test@123");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
