package Java_Web_Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SwitchToNewWindow {
    WebDriver driver = null;

    @BeforeSuite
    public void LaunchBrowser() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test(priority = 1)
    public void ScrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

    }

    @Test(priority = 2)
    public void demoSwitchToFrame1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("intercom-launcher-frame"));

        driver.findElement(By.className("e2ujk8f2")).click();
    }

    @Test(priority = 3)
    public void demoSwitchToFrame2() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("intercom-launcher-frame")));

        driver.switchTo().frame("intercom-launcher-frame");
        driver.findElement(By.className("e2ujk8f2")).click();
    }

    @Test(priority = 4)
    public void TestSwitchToNewBrowser() {
        driver.findElement(By.id("OK")).click();

        ////////////////
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        //Or store the dimensions and query them later
        Dimension size = driver.manage().window().getSize();
        /////////////

        int width1 = size.getWidth();
        int height1 = size.getHeight();
        driver.manage().window().setSize(new Dimension(1024, 768));

        String originalWindow = driver.getWindowHandle();
        Set<String> originalWindow1 = driver.getWindowHandles();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Test(priority = 5)
    public void SwitchToBackToDefault() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.softwaretestinghelp.com/");

        //Finding all iframe tags on a web page
        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
        int numberOfTags = elements.size();
        System.out.println("No. of Iframes on this Web Page are: " + numberOfTags);

        // Switch to the frame using the frame id
        System.out.println("Switching to the frame");
        driver.switchTo().frame("aswift_0");

        // Print the frame source code
        System.out.println("Frame Source" + driver.getPageSource());

        // Switch back to main web page
        driver.switchTo().defaultContent();

        // driver.quit();
    }

    @Test
    public void SwitchTo_newWindow() {
    /*
        There is clearly a difference :
        Scenario : When there are multiple frames and some of them are nested.
        iframeMain
        iframeParent
        iframechild
        Assume you are in ifrmaechild :
        When you do driver.switchTo().parentFrame(); : you will go to iframeParent .
        But when you do driver.switchTo().defaultContent(); : you will go to main HTML of page.
        Note that in this case you will not go to iframeMain .
     */
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.browserstack.com/");
        System.out.println("Before defaultContent" + driver.getTitle());
        String Title = driver.switchTo().defaultContent().getTitle();
        System.out.println("After defaultContent" + Title);

        driver.switchTo().parentFrame();
    }

    @Test
    public void openNewWindowForTestProjectBlog() {
        Set<String> test = driver.getWindowHandles();

        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://blog.testproject.io/");
        System.out.println(driver.getTitle());
    }

    @Test
    public void SwitchToAlert() {
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        String TextValue = driver.switchTo().alert().getText();
    }

    @Test
    public void SwitchToNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
    }

    @Test
    public void GetWindowHandles_Test() {
        String curHandle = driver.getWindowHandle();
        Set<String> AllHandles = driver.getWindowHandles();

        for (String c : AllHandles) {
            if (!curHandle.contentEquals(c)) {
                driver.switchTo().window(c);
                break;
            }
        }
    }

    @Test
    public void SwitchToFrames() {
        driver.switchTo().frame(1);
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }

}
