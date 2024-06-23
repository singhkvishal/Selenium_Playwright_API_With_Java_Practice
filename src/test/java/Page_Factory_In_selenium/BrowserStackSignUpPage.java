package Page_Factory_In_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class BrowserStackSignUpPage {
    WebDriver driver;

    @FindBy(xpath = "//h1")
    WebElement Header;

    @FindBy(xpath = "(//a[@class=\"sign-up-link hide-in-os-page\"])[1]")
    WebElement SignUp;

    @FindBy(xpath = "//*[@id='user_full_name']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='user_email_login']")
    WebElement businessEmail;

    @FindBy(xpath = "//*[@id='user_password']")
    WebElement password;

    @FindBy(xpath = "//input[@id=\"tnc_checkbox\"]")
    WebElement terms_and_conditions;


    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Click_On_SignUp(){
        SignUp.click();
    }

    public void veryHeader() {
        String getheadertext = Header.getText().trim();
        assertEquals("Create a FREE Account", getheadertext);
    }
    public void enterFullName(String arg1) {
        userName.sendKeys(arg1);
    }
    public void enterBusinessEmail(String arg1) {
        businessEmail.sendKeys(arg1);
    }
    public void enterPasswrod(String arg1) {
        password.sendKeys(arg1);
    }
    public void TermAndCondition(){
        terms_and_conditions.click();
    }
}
