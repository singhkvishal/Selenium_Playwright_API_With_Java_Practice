package Applitools_Example;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

// Login to below URL and check the Screen Validation
//https://eyes.applitools.com/app/test-results/00000251659420257089/?accountId=EiJaE4qGVESMOnaZhEtL_Q__

public class AppTest {
    @Test
    public void test(){
        WebDriver driver=new ChromeDriver();

        Eyes eyes=new Eyes();
        eyes.setApiKey("yPl2Mv9kCl9K3Aj6iDXApt2qnkn59M6bsBgt7DFRBoY110");
        eyes.open(driver,"HellpApp","FirstTest");

        driver.get("https://applitools.com/helloworld");
        //driver.get("https://applitools.com/helloworld/?diff1");
        eyes.checkWindow("Test");
        eyes.close();
        driver.quit();
        eyes.abortIfNotClosed();
    }
}
