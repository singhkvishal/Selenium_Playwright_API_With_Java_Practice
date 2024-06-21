package Java_Web_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebElementsActions {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //  options.addArguments("headless");
        options.addArguments("--start-maximized");
        // options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //options.setCapability("proxy","Proxy");
        driver = new ChromeDriver(options);
    }

    @Test(enabled = false)
    public void ClickonButon() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test(enabled = false)
    public void SetTextBox() {
        driver.findElement(By.name("my-text")).sendKeys("Test");
    }

    @Test(enabled = false)
    public void SelectDropDown() {
        WebElement DropDown = driver.findElement(By.name("my-select"));
        Select sel = new Select(DropDown);
        sel.selectByValue("One");
    }

    @Test(enabled = false)
    public void SelectCheckBox() {
        if (!driver.findElement(By.id("my-check-2")).isSelected())
            driver.findElement(By.id("my-check-2")).click();
    }

    @Test(enabled = false)
    public void ActionClass() throws InterruptedException {
        driver.get("https://www.orangehrm.com/");
        driver.manage().window().maximize();
        WebElement clickable = driver.findElement(By.xpath("//*[text()='Solutions']"));
        Thread.sleep(5000);
        new Actions(driver)
                .click(clickable)
                .pause(Duration.ofSeconds(1))
                .click(driver.findElement(By.xpath("(//*[text()='Talent Management'])[1]")))
                .pause(Duration.ofSeconds(1))
                .click(driver.findElement(By.xpath("//*[text()='Recruitment (ATS)]")))
                .perform();
    }

    @Test
    public void UploadFile() {
        driver.get("https://www.selenium.dev/selenium/web/upload.html");
        driver.findElement(By.id("upload")).sendKeys("D:\\Study\\Selenium\\SenleniumTestDemo\\testng.xml");
    }

    @Test
    public void ScrollBar() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/");
        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.xpath("//*[text()='web-form.html']"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();
/*

    WebElement footer = driver.findElement(By.tagName("footer"));
    int deltaY = footer.getRect().y;
    new Actions(driver)
            .scrollByAmount(0, deltaY)
            .perform();


    WebElement iframe1 = driver.findElement(By.tagName("iframe"));
    WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe1);
    new Actions(driver)
            .scrollFromOrigin(scrollOrigin, 0, 200)
            .perform();

    WebElement footer2 = driver.findElement(By.tagName("footer"));
    WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromElement(footer2, 0, -50);
    new Actions(driver)
            .scrollFromOrigin(scrollOrigin1,0, 200)
            .perform();


    WheelInput.ScrollOrigin scrollOrigin3 = WheelInput.ScrollOrigin.fromViewport(10, 10);
    new Actions(driver)
            .scrollFromOrigin(scrollOrigin3, 0, 200)
            .perform();*/
    }
}
