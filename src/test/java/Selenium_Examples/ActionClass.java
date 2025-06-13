package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass {
    WebDriver driver;

    @BeforeSuite
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 0)
    public void KeyAction() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
        WebElement e = driver.findElement(By.xpath("//*[@id='fullname']"));

        // Actions class
        Actions a = new Actions(driver);

        // moving to an input box and clicking on it
        a.moveToElement(e).click();

        // key UP and DOWN action for SHIFT
        a.keyDown(Keys.SHIFT);
        a.sendKeys("Selenium").keyUp(Keys.SHIFT).build().perform();
        System.out.println("Text entered: " + e.getAttribute("value"));
    }

    @Test(priority = 1)
    public void DragAndDrp() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");
        // identify source and target elements for drag and drop
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));

        // drag and drop operations without build and perform methods
        Actions a = new Actions(driver);
        a.dragAndDrop(sourceElement, targetElement).build().perform();

        // identify text after element is dropped
        WebElement text = driver.findElement(By.xpath("//*[@id='droppable']/p"));
        System.out.println("Text is : " + text.getText());
    }

    @Test(priority = 2)
    public void ActionsClickAndHold() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/menu.php#");
        WebElement m = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/nav/div/a"));

        // get element color in rgba format
        String s = m.getCssValue("color");

        System.out.println("rgba code for color element: " + s);

        // object of Actions class to click and hold
        Actions a = new Actions(driver);
        a.clickAndHold(m).build().perform();

        // get element color in rgba format
        String c = m.getCssValue("color");
        System.out.println("rgba code for color for element after click and hold: " + c);
    }

    @Test(priority = 3)
    public void ActionsMouse() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");

        WebElement m = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/button[1]"));

        // object of Actions class to move then click
        Actions a = new Actions(driver);
        a.moveToElement(m).click().build().perform();

        // get text after click
        WebElement t = driver.findElement(By.xpath("//*[@id='welcomeDiv']"));
        System.out.println("Text after click: " + t.getText());

        // identify element with xpath for double click
        WebElement n = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/button[3]"));

        // double click
        a.moveToElement(n).doubleClick().build().perform();

        // get text after double click
        WebElement x = driver.findElement(By.xpath("//*[@id='doublec']"));
        System.out.println("Text after double click: " + x.getText());

        // identify element with xpath for right click
        WebElement y = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/button[2]"));

        // right click
        a.moveToElement(y).contextClick().build().perform();
    }

    @AfterSuite
    public void Close() {
        driver.close();
    }
}