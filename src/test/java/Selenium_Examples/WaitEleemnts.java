package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;


public class WaitEleemnts {

    protected WebDriver driver;

    @BeforeTest
    public void Befoe() {
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public void ImplicitlyWait_Test() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String eTitle = "Demo Guru99 Page";
        String aTitle = "";
        aTitle = driver.getTitle();
        if (aTitle.equals(eTitle)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }

    @Test(priority = 1)
    public void EmplicitWait_Test() {
        WebElement guru99seleniumlink;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        guru99seleniumlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rt-feature\"]/div/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div")));
        guru99seleniumlink.click();
    }


    @Test(priority = 2)
    public void FluentWait_Test() {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>() {

            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@id=\"rt-feature\"]/div/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div[1]/div/div"));
            }
        });
        clickseleniumlink.click();
    }

    @AfterTest
    public void close() {
        driver.close();
    }

}
