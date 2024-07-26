package Playwright_Examples.launchBrowsers;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ColorScheme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LaunchBrowser_Options {
    Playwright playwright;

    @BeforeSuite
    public void setUp() {
        playwright = Playwright.create();
    }

    @Test(priority = 1)
    public void LaunchHeadLessMos() {
        //By default, Playwright runs the browsers in headless mode.
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        System.out.println("Page Title: " + page.title());
        System.out.println("Page URL: " + page.url());
    }

    @Test(priority = 2)
    public void LaunchWithHeadedMode() {
        //To see the browser UI, pass the headless=false flag while launching the browser.
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        Page page = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)).newPage();
        page.navigate("http://playwright.dev");
        System.out.println("Page Title: " + page.title());
        System.out.println("Page URL: " + page.url());
    }

    @Test(priority = 3)
    public void LaunchChromeBrowser() {
        //By default, Playwright runs the browsers in headless mode.
        //Browser distribution channel. Supported values are "chrome", "chrome-beta", "chrome-dev", "chrome-canary", "msedge", "msedge-beta", "msedge-dev", "msedge-canary"
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        browserContext.setDefaultTimeout(60_000);
        browserContext.setDefaultNavigationTimeout(60_000);
        Page page = browserContext.newPage();
        page.waitForTimeout(60_000);
        page.navigate("http://playwright.dev");
        System.out.println("Page Title: " + page.title());
        System.out.println("Page URL: " + page.url());
    }

    @Test(priority = 4)
    public void LaunchWebKitBrowser() {
        //By default, Playwright runs the browsers in headless mode.
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://playwright.dev/java/docs/api/class-browsercontext");
        //page.waitForURL("java/docs/api/class-browsercontext");
        System.out.println("Page Title: " + page.title());
        System.out.println("Page URL: " + page.url());
    }

    @Test(priority = 5)
    public void SetViewPortSize() {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)
                .setColorScheme(ColorScheme.DARK).setLocale("de-DE"));
        Page page = context.newPage();
        page.navigate("https://www.google.co.in/");
        System.out.println(page.title());
    }

    @Test(priority = 6)
    public void MultipalBrowserContext() {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext cont1 = browser.newContext();
        Page page1 = cont1.newPage();
        page1.navigate("https://practicetestautomation.com/practice-test-login/");
        page1.fill("//*[@id='username']", "student");
        page1.locator("//*[@id='password']").fill("Password123");
        page1.locator("//*[@id=\"submit\"]").click();

        BrowserContext cont2 = browser.newContext();
        Page page2 = cont2.newPage();
        page2.navigate("https://practicetestautomation.com/practice-test-login/");
        page2.fill("//*[@id='username']", "student");
        page2.locator("//*[@id='password']").fill("Password123");
        page2.locator("//*[@id=\"submit\"]").click();

        System.out.println(browser.contexts().size()); // prints "2"
        System.out.println(browser.browserType());
    }

    @AfterSuite
    public void TearDown() {
        playwright.close();
    }
}
