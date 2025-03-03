package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {
    @Test
    public void RelativeLocatorTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement webElement = driver.findElement(By.name("my-password"));

        WebElement ele1 = driver.findElement(with(By.tagName("input")).above(webElement));
        WebElement ele2 = driver.findElement(with(By.tagName("input")).below(webElement));
        WebElement ele3 = driver.findElement(with(By.tagName("input")).toLeftOf(webElement));
        WebElement ele4 = driver.findElement(with(By.tagName("input")).toRightOf(webElement));
        WebElement ele5 = driver.findElement(org.openqa.selenium.support.locators.RelativeLocator.with(By.tagName("input")).near(webElement));
    }
}
