package Test_Reports.ChainTest_Report;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage {

    public SecurePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//*[@id='flash']")
    public WebElement securePageTitle;

    public String getSecurePageTitle() {
        return securePageTitle.getText();
    }

}