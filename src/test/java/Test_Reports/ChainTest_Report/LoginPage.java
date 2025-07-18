package Test_Reports.ChainTest_Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[@id='flash']")
    public WebElement errorMessage;

    public void login(String strUserName, String strPassword) {
        userName.sendKeys(strUserName);
        password.sendKeys(strPassword);
        loginBtn.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}