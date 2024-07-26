package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleDroupDowns {
    @Test(priority = 1)
    public void Test1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Select sel = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        sel.selectByValue("USD");
        sel.deselectByIndex(1);
    }

    @Test(priority = 2)
    public void Test2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000L);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        for (int i = 1; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
    }

    @Test
    public void Test3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//*[@data-cy='closeModal']")).click();
        WebElement source = driver.findElement(By.xpath("//*[@placeholder='From']"));
        source.click();
        //source.clear();
        source.sendKeys("MUM");
        Thread.sleep(2000);
        source.sendKeys(Keys.ENTER);

        WebElement destination = driver.findElement(By.xpath("//input[@id='fromCity']"));
        destination.click();
        destination.sendKeys("DEL");
        Thread.sleep(2000);
        destination.sendKeys(Keys.ARROW_DOWN);
        destination.sendKeys(Keys.ENTER);
    }
}
