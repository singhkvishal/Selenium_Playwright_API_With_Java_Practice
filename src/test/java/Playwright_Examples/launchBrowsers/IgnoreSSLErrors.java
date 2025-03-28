package Playwright_Examples.launchBrowsers;

import com.microsoft.playwright.*;

public class IgnoreSSLErrors {
    public static void main(String[] args) throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));

            Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions().setIgnoreHTTPSErrors(true);
            BrowserContext browserContext = browser.newContext(newContextOptions);

            Page page = browserContext.newPage();
            page.navigate("file:///C:/Users/vishal/Downloads/Finalise%20CV%20%E2%80%93%20LiveCareer.mhtml");
            page.close();
        }
    }
}
