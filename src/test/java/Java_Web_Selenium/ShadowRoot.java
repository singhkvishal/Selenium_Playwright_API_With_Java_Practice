package Java_Web_Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ShadowRoot {
    WebDriver driver = null;

    @BeforeSuite
    public void LaunchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");
    }

    @Test
    public void ShadowRootTest() {
        //driver.switchTo().frame("pact");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement Element = (WebElement) jse.executeScript("return document.querySelector('#userName').shadowRoot.querySelector('#kils')");

        //1- Using the Selenium
        Element.sendKeys("Vishal");

        //2- using executeScript
        String js="arguments[0].setAttribute('value','Vishal Singh')";
        jse.executeScript(js,jse);

    }
}
