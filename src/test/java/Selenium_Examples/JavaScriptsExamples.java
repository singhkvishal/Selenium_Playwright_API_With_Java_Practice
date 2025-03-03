package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaScriptsExamples {
    WebDriver driver;

    @BeforeSuite
    public void Setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000);
    }

    @Test
    public void ScrollPageAndTable() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        int sum = 0;
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        for (WebElement value : values) {
            sum = sum + Integer.parseInt(value.getText());
        }

        /*for (int i = 0; i < values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }*/

        System.out.println(sum);
        driver.findElement(By.cssSelector(".totalAmount")).getText();
        String ActualValue = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        Assert.assertEquals(sum, Integer.parseInt(ActualValue));
    }


    @Test
    public void SumAllAmount() {
        AtomicInteger totalValue = new AtomicInteger();
        List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        amounts.forEach(amount -> {
            totalValue.set(totalValue.get() + Integer.parseInt(amount.getText()));
        });

        System.out.println("Total Amount" + totalValue);

        String expectedValue = driver.findElement(By.cssSelector(".totalAmount")).getText();
        Assert.assertEquals(Integer.parseInt(expectedValue.split(":")[1].trim()), totalValue);
    }
}