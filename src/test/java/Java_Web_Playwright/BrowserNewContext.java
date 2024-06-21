package Java_Web_Playwright;

import com.microsoft.playwright.*;

public class BrowserNewContext {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext cont1 = browser.newContext();
            Page page1 = cont1.newPage();
            page1.navigate("https://practicetestautomation.com/practice-test-login/");
            page1.fill("//*[@id='username']", "student");
            //  page.locator("//*[@id='username']").fill("student");
            page1.locator("//*[@id='password']").fill("Password123");
            page1.locator("//*[@id=\"submit\"]").click();

            BrowserContext cont2 = browser.newContext();
            Page page2 = cont2.newPage();
            page2.navigate("https://playwright.dev/java/docs/browser-contexts#multiple-contexts-in-a-single-test");
        }
    }
}
