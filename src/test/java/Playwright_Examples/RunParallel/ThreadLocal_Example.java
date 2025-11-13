package Playwright_Examples.RunParallel;

import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadLocal_Example {
    private final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private final ThreadLocal<BrowserContext> context = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        BrowserContext ctx = br.newContext();

        playwright.set(pw);
        browser.set(br);
        context.set(ctx);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        BrowserContext ctx = context.get();
        if (ctx != null) {
            ctx.close();
            context.remove();
        }

        Browser br = browser.get();
        if (br != null) {
            br.close();
            browser.remove();
        }

        Playwright pw = playwright.get();
        if (pw != null) {
            pw.close();
            playwright.remove();
        }
    }

    @Test
    public void exampleDomainShouldExposeHeading() {
        assertTextPresent("https://example.com", "h1", "Example Domain");
    }

    @Test
    public void playwrightBlogShouldLoadArticles() {
        assertVisibility("https://playwright.dev/java/blog", "article");
    }

    @Test
    public void playwrightApiReferenceShouldExposeSearch() {
        assertVisibility("https://playwright.dev/java/docs/api/class-playwright", "input[type='search']");
    }

    private void assertTextPresent(String url, String selector, String expectedText) {
        try (Page page = context.get().newPage()) {
            page.navigate(url);
            String actual = page.locator(selector).innerText();
            Assert.assertTrue(actual.contains(expectedText),
                    String.format("Expected '%s' to contain '%s' on %s", actual, expectedText, url));
        }
    }

    private void assertVisibility(String url, String selector) {
        try (Page page = context.get().newPage()) {
            page.navigate(url);
            Assert.assertTrue(page.locator(selector).first().isVisible(),
                    String.format("Expected selector '%s' to be visible on %s", selector, url));
        }
    }
}
