package Java_Selenium_PageObjectModel_Using_PageFactory.testCases;

import Java_Selenium_PageObjectModel_Using_PageFactory.pages.Login;
import Java_Selenium_PageObjectModel_Using_PageFactory.pages.Profile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class Login_TC {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        //Instantiating Login & Profile page using initElements()
        Login loginPg = PageFactory.initElements(driver, Login.class);
        Profile profilePg = PageFactory.initElements(driver, Profile.class);

        //Using the methods created in pages class to perform actions
        loginPg.LogIn_Action("testLofin", "Password");
        profilePg.verifyUser("Invalid username or password!");
        profilePg.logout_Action();

        driver.quit();
    }
}