package Test_Reports.ChainReport_TestNG;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest extends TestBase {
    @Test
    public void tc_01(){
        LogInPage loginPage= PageFactory.initElements(driver,LogInPage.class);
        loginPage.typeUserName("Admin");
        loginPage.typePassword("admin123");
        loginPage.ClickLogInButton();
    }
}
