package AI;

/*

import com.epam.healenium.SelfHealingDriver;

import static org.assertj.core.api.Assertions.assertThat;

import com.testrigor.selfhealingselenium.SelfHealingDriver;
import com.testrigor.selfhealingselenium.TestRigor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

@Test
public class SelfHealingIT {
    private static final int SECONDS_TIMEOUT = 4;
    private static final String TEST_TEXT = "test123";

    public void test_Selenium_tests_heals_for_path_and_tag_change() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        //RemoteWebDriver driver = new ChromeDriver();
        SelfHealingDriver driver = TestRigor.selfHeal(new ChromeDriver(), "a2518f3a-3e8b-484a-befe-23b9160ef166");
        driver.manage().timeouts().implicitlyWait(SECONDS_TIMEOUT, TimeUnit.SECONDS);
        driver.get("http://r4d4.info/form-button-label");
        actualTest(driver);
        driver.get("http://r4d4.info/form-button-label2");
        actualTest(driver);
    }

    private void actualTest(RemoteWebDriver driver) {
        WebElement input = driver.findElementById("messageNew");
        WebElement button = driver.findElementById("changer");
        input.sendKeys(TEST_TEXT);
        button.click();
        WebElement result = driver.findElementByXPath("/html/body/div/p[1]");
        String text = result.getText();
        assertThat(text).contains(TEST_TEXT);
    }
}

*/
