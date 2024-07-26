package Selenium_Examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWait {
    WebDriver driver = null;

    @BeforeSuite
    public void LaunchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    void implicitly_Wait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.navigate().to("https://www.baeldung.com/");
    }

    @Test
    public void Explicit_Waits() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("reveal")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement revealed = driver.findElement(By.id("revealed"));

        wait.until(d -> revealed.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id")));
    }

    @Test
    void Fluent_Wait() {
        driver.navigate().to("https://www.baeldung.com/");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("")));
        fluentWait.until(ExpectedConditions.elementToBeClickable(By.name("")));

        //========================
        WebElement revealed = driver.findElement(By.id("revealed"));
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    revealed.sendKeys("Displayed");
                    return true;
                });
    }

    @Test
    void TestSwitchCase() {
        switch (1) {
            case 1:
                System.out.println("First");
            case 2:
                System.out.println("Second");
                break;

            default:
                System.out.println("Final");
        }
    }

    @Test
    void SwitchCase1() {
        int a = 5;
        System.out.println(a++ + a++);
    }
}