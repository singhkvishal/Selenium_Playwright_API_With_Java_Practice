package Java_Web_Playwright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class ReactSelector {
    @Test

    public  void Test(){
        Playwright playwright=Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page=browser.newPage();
        page.navigate("https://www.netflix.com/");

        Locator email=page.locator("_react=p[name='email'] >> input").first();
        email.click();
        email.fill("vishalsingh@gmail.com");
        page.pause();
    }
}
