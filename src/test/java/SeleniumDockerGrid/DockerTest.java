package SeleniumDockerGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/*
1- Save this file
docker-selenium/docker-compose-v3.yml at trunk · SeleniumHQ/docker-selenium · GitHub

2- Run the command docker-compose up
3-Check this Grid Status
http://localhost:4444/grid/console
3- Scale Up the Docker(increase the number of Nodes)

Docker-compose scale chrome=3
 */

public class DockerTest {
    @Test
    public void Chrome() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        WebDriver driver =new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Vishal Singh");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void Chrome1() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        WebDriver driver =new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Vishal Singh");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void Chrome3() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        WebDriver driver =new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Vishal Singh");
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void FireFox() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("firefox");
        WebDriver driver =new RemoteWebDriver(new URI("http://localhost:4444/wd/hub").toURL(),cap);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Vishal Singh");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
