package Cucumber_Examples;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class StepsDefinitions {
    private final WebDriver driver = new ChromeDriver();

    @Given("user navigates to the login page by opening Chrome")
    public void user_is_on_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    //Entering correct username and password values
    @And("Validate the Page")
    public void ClickOnSignIn() {
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @When("Enter the Business Email ID & Password")
    public void enter_Username_Password() {
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
    }

    @Then("Click on Sign me in")
    public void ClickOnSignMeIn() {
        driver.findElement(By.xpath("//*[text()=' Login ']")).click();
    }

    @But("Validate the Login Page")
    public void ValidateLogin(){
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"oxd-sidepanel-header\"]")).isDisplayed());
    }
    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
