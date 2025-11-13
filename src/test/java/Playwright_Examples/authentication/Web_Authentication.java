package Playwright_Examples.authentication;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.HttpCredentials;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Web_Authentication {
    Playwright playewright;

    @BeforeSuite
    public void Setup() {
        playewright = Playwright.create();
    }

    @Test
    public void PopUpLogin() {
        Browser browser = playewright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext brContext = browser.newContext();
        Page page = brContext.newPage();
        page.navigate("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void LogInUsing_setHttpCredentials() {
        Browser browser = playewright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        HttpCredentials auth = new HttpCredentials("admin", "admin");
        BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setHttpCredentials(auth));
        Page page = brContext.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        page.pause();
    }

    @AfterSuite
    public void TearDown() {
        playewright.close();
    }
}
