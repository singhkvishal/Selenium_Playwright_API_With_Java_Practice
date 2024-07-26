package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class HandleBrokenLinks {
    //Broken links means link is not working
    WebDriver driver;
    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test(priority = 0)
    public void CheckTheLinkIsBroken() throws MalformedURLException, IOException {
        String linkSoapUI = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
        CheckLinkIsNotBroken(linkSoapUI);
    }

    @Test(priority = 1)
    public void CheckAllLinksAreNotBroken() throws InterruptedException, IOException {
        List<WebElement> WebLinks = driver.findElement(By.id("gf-BIG")).findElements(By.tagName("a"));
        for (WebElement link : WebLinks) {
            String linkUrl = link.getAttribute("href");
            CheckLinkIsNotBroken(linkUrl);
        }
    }

    public void CheckLinkIsNotBroken(String UrlLink) throws IOException {
        URLConnection openConnection = new URL(UrlLink).openConnection();
        HttpURLConnection conn = (HttpURLConnection) openConnection;
        conn.setRequestMethod("HEAD");
        conn.connect();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(conn.getResponseCode() < 400, UrlLink + "==Link is NOT working fine");
        softAssert.assertAll();

        softAssert.assertEquals(conn.getResponseCode(), 200);
        if (conn.getResponseCode() <= 200) {
            System.out.println(UrlLink + "=>Link is working fine");
        } else {
            System.out.println(UrlLink + "=>Link is NOT working fine");
        }
    }

    @AfterSuite
    public void TearDown(){
        driver.close();
    }
}
