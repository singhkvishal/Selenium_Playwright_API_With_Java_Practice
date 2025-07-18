package Test_Reports.ChainTest_Report;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTests {

    String actualLoginPageTitle;
    String actualErrorMessage;
    String actualDashboardPageTitle;

    @Test(priority = 0)
    public void verifyPageTitle() {
        actualLoginPageTitle = driver.getTitle();

        // Verify Page Title - Failed Test
        Assert.assertEquals(actualLoginPageTitle, "The Internet");
    }

    @Test(priority = 1)
    public void invalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "happy!");
        actualErrorMessage = loginPage.getErrorMessage();

        // Verify Error Message
        Assert.assertTrue(actualErrorMessage.contains("Your password is invalid!"));
    }

    @Test(priority = 2)
    public void validLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
       String actualSecurePageTitle = securePage.getSecurePageTitle();

        // Verify Home Page
        Assert.assertTrue(actualSecurePageTitle.contains("You logged into a secure area!"));
    }
}