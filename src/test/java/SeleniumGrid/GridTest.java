package SeleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class GridTest {
    @Test
    public void Chrome() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        WebDriver driver =new RemoteWebDriver(new URI("http://192.168.1.38:4444").toURL(),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Vishal Singh");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
