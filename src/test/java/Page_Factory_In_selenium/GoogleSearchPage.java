package Page_Factory_In_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    //https://www.lambdatest.com/blog/findby-annotation-selenium-java/
    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        // Call initElements() method by using PageFactory reference and pass driver and this as parameters.
        PageFactory.initElements(driver, this);
    }

    // Locate all elements using locators in the home page.
    @FindBy(how = How.NAME, using = "q")
    WebElement searchBox;
    @FindBy(how = How.NAME, using = "btnK")
    WebElement submit;

    // Declare methods to perform operations on the elements.
    public void title() {
        String getTitle = driver.getTitle();
        System.out.println("Title of Homepage: " + getTitle);
    }

    public void search() {
        searchBox.sendKeys("Selenium");
    }

    public void submit() {
        submit.click();
    }
}