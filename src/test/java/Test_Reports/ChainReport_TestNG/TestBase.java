package Test_Reports.ChainReport_TestNG;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.time.Duration;

//@Listeners(ChainTestListener.class)
public class TestBase extends TestListenerAdapter {
    public static WebDriver driver;

    @BeforeEach
    public void OpenBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterEach
    public void CloseBrowser() {
        driver.quit();
    }
}