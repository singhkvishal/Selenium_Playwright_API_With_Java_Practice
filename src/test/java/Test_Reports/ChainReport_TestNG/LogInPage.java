package Test_Reports.ChainReport_TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
    @FindBy(name = "username")
    WebElement txtUserName;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath="//button[@type='submit']")
    WebElement btnSubmit;

    public void typeUserName(String UserName) {
        txtUserName.sendKeys(UserName);
    }

    public void typePassword(String Password) {
        txtPassword.sendKeys(Password);
    }

    public void ClickLogInButton() {
        btnSubmit.click();
    }
}
