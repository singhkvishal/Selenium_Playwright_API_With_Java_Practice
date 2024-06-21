package Page_Factory_In_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestClass {
    static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 0)
    public void googleSearch() {
// Create an object of GoogleSearchPage class.
        GoogleSearchPage gs = new GoogleSearchPage(driver);
        gs.title();  // Calling title method.
        gs.search(); // Calling search method.
        gs.submit(); // Calling submit method.
    }

    @AfterTest
    public void closing() {
        TestClass.driver.quit();
    }
}