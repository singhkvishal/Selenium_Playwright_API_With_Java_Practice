package Java_Examples.AutoDesignPattern.BuilderPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegPageTest {
    WebDriver driver;

    @BeforeTest
    public void Setup() {
        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
    }

    @Test
    public void userRegTest() {
        Register register = new Register.RegisterBuilder()
                .setFirstName("Vishal")
                .setLastName("Singh")
                .setEmail("aasdfkj@gmail.com")
                .setTelephone("2424235435")
                .setPassword("adasdsad")
                .setConformPassword("adasdsad")
                .build();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.userRegister(register);
    }

    @AfterTest
    public void TearDown() {
        driver.quit();
    }
}
