package ParallelTest_Examples.Cucumber_Example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cucumber_LoginTest {
    @Given("Launch the Browser")
    public void LaunchBrowser() {
        System.out.println("Browser is Launched!");
    }

    @When("Validate the Browser is Launched")
    public void ValidateBrowser() {
        System.out.println("Login Window is Displayed!");
    }
    @When("Enter the User name {string}")
    public void enter_the_user_name(String UserName) {
        System.out.println(UserName+ " User ID is Entered");
    }
    @When("Enter the Password {string}")
    public void enter_the_password(String Pass) {
        System.out.println(Pass+ " Password is Entered");
    }

    @Then("Click on Login Button")
    public void LoginClick() {
        System.out.println("Login Button is clicked");
    }

    @And("Validate the User is login")
    public void ValidateLogIn() {
        System.out.println("Validate the Login Page");
    }

}