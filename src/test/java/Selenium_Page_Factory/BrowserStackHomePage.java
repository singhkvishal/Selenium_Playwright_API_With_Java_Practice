package Selenium_Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.AssertJUnit.assertEquals;

public class BrowserStackHomePage {
    WebDriver driver;
    @FindBy(xpath = "//h1")
    WebElement Header;
    @FindBy(xpath = "//a[@title=\"Sign in\"]")
    WebElement SignIn;

    public BrowserStackHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void veryHeader() {
        String getheadertext = Header.getText();
        assertEquals("App & Browser Testing Made Easy", getheadertext);
    }
    public void clickOnGetStarted() {
        SignIn.click();
    }
}
