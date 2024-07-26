package Selenium_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class WindowsAuthentication {
    @Test
    public void Test1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        driver.findElement(By.linkText("Basic Auth")).click();
    }

    @Test
    public void Test2() throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Basic Auth")).click();
        Runtime.getRuntime().exec("D:\\Study\\Selenium\\AutoIt_UploadDoc.exe");
    }
}
