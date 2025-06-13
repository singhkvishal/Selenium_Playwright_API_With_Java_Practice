package Selenium_BDD_Framework.resources.resources.test.java.StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import Selenium_BDD_Framework.resources.resources.test.java.pagefactory.HomePage_PF;
import Selenium_BDD_Framework.resources.resources.test.java.pagefactory.LoginPage_PF;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
//import pagefactory.HomePage_PF;
//import pagefactory.LoginPage_PF;

public class LoginDemoSteps_PF {

	WebDriver driver = null;
	LoginPage_PF login;
	HomePage_PF home;

	@Given("browser is open")
	public void browser_is_open() {

		System.out.println("  ===  I am inside LoginDemoSteps_PF class ===== ");

		System.out.println("Inside Step - browser is open");

		//String projectPath = System.getProperty("user.dir");
		///System.out.println("Project path is : " + projectPath);

		//System.setProperty("webdriver.gecko.driver", projectPath + "/src/test/resources/drivers/geckodriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		//driver.manage().window().maximize();

	}

	@And("Validate user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://example.testproject.io/web/");

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {

		login = new LoginPage_PF(driver);

		login.enterUsername(username);
		login.enterPassword(password);

		// driver.findElement(By.id("name")).sendKeys(username);
		// driver.findElement(By.id("password")).sendKeys(password);

		Thread.sleep(2000);
	}

	@And("user clicks on login")
	public void user_clicks_on_login() {

		login.clickOnLogin();
		// driver.findElement(By.id("login")).click();
	}


	@Then("Validate user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {

		home.checkLogoutIsDisplayed();
		// driver.findElement(By.id("logout")).isDisplayed();

		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
