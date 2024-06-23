package Page_Object_Model_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class BrowserStackSignUpPage {
    WebDriver driver;
    By signUp=By.xpath("(//a[@class=\"sign-up-link hide-in-os-page\"])[1]");
    By Header = By.xpath("//h1");
    By userName = By.xpath("//*[@id='user_full_name']");
    By businessEmail = By.xpath("//*[@id='user_email_login']");
    By password = By.xpath("//*[@id='user_password']");
    By terms_and_conditions = By.xpath("//input[@id=\"tnc_checkbox\"]");

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void Click_On_SignUp(){
        driver.findElement(signUp).click();
    }
    public void veryHeader() {
        String getheadertext = driver.findElement(Header).getText().trim();
        assertEquals("Create a FREE Account", getheadertext);
    }
    public void enterFullName(String arg1) {
        driver.findElement(userName).sendKeys(arg1);
    }
    public void enterBusinessEmail(String arg1) {
        driver.findElement(businessEmail).sendKeys(arg1);
    }
    public void enterPasswrod(String arg1) {
        driver.findElement(password).sendKeys(arg1);
    }
    public void TermAndCondition(){
        driver.findElement(terms_and_conditions).click();
    }
}
