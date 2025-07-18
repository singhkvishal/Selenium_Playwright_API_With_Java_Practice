package Test_Reports.ChainTest_Report;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import java.time.Duration;

@Listeners(ChainTestListener.class)
public class BaseTests {

    public static WebDriver driver;
    public final static int TIMEOUT = 10;

    @BeforeTest
   // @Parameters("browserName")
    public void setup( ) throws Exception {
      String  browserName="chrome";
        System.out.println("Browser : " + browserName);

        switch (browserName.toLowerCase().trim()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case ("edge"):
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Incorrect browser is supplied...." + browserName);
                throw new IllegalArgumentException("Wrong Browser provided: " + browserName);
        }

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}