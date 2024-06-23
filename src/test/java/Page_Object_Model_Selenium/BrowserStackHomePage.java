package Page_Object_Model_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;
public class BrowserStackHomePage {
    WebDriver driver;
    By Header=By.xpath("//h1");
    By getStarted=By.xpath("//a[@title=\"Sign in\"]");
    By SingUp=By.xpath("//a[@title=\"Sign in\"]");
    public BrowserStackHomePage(WebDriver driver) {
        this.driver=driver;
    }
    public void Click_On_SignUp(){
        driver.findElement(SingUp).click();
    }
    public void veryHeader() {
        String getheadertext=driver.findElement(Header).getText();
        assertEquals("App & Browser Testing Made Easy", getheadertext);
    }
    public void clickOnGetStarted() {
        driver.findElement(getStarted).click();
    }
}
