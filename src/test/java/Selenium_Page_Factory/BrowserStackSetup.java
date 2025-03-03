package Selenium_Page_Factory;


//import Selenium_Page_Factory.BrowserStackHomePage;
import com.aventstack.chaintest.http.ChainTestApiClient;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserStackSetup {
    WebDriver driver;
    BrowserStackHomePage objBrowserStackHomePage;
    BrowserStackSignUpPage objBrowserStackSignUpPage;

    @BeforeTest
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.browserstack.com/");
        driver.manage().window().maximize();
        ChainTestListener.log("Browser is Launched");
    }

    @Test(priority = 1)
    public void navigate_to_homepage_click_on_getStarted() {
        objBrowserStackHomePage = new BrowserStackHomePage(driver);
        objBrowserStackHomePage.veryHeader();
        ChainTestListener.log("Header is Verified");
        objBrowserStackHomePage.clickOnGetStarted();
        ChainTestListener.log("Click on Get Started Page");
    }

    @Test(priority = 2)
    public void enter_userDetails() {
        objBrowserStackSignUpPage = new BrowserStackSignUpPage(driver);
        objBrowserStackSignUpPage.Click_On_SignUp();
        ChainTestListener.log("Click on SignUp Page");
        objBrowserStackSignUpPage.veryHeader();
        objBrowserStackSignUpPage.enterFullName("TestUser");
        objBrowserStackSignUpPage.enterBusinessEmail("TestUser@gmail.com");
        objBrowserStackSignUpPage.enterPasswrod("TestUserPassword");
        objBrowserStackSignUpPage.TermAndCondition();
    }
    @AfterTest
    public void Close(){
        driver.close();
    }
}
