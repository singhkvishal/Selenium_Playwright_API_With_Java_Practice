package Playwright_Examples.authentication;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import java.nio.file.Paths;
public class BrowserContext_storageState {
    @Test
    public  void CreateBrowserStorageState() {
        // Save the Browser storageState Context
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true));
            Page page = brContext.newPage();
            page.navigate("https://practicetestautomation.com/practice-test-login/");
            page.fill("//*[@id='username']", "student");
            page.locator("//*[@id='password']").fill("Password123");
            page.locator("//*[@id=\"submit\"]").click();
            brContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("Application.json")));
        }
    }
    // Use Browser Context
    @Test
    public  void SetBrowserStorageState() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("Application.json")));
            Page page = brContext.newPage();
            page.navigate("https://practicetestautomation.com/logged-in-successfully/");
        }
    }
}
