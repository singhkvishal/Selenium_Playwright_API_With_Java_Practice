package Playwright_Examples.RunParallel;
import com.microsoft.playwright.*;

import java.nio.file.Paths;

import static java.util.Arrays.asList;

public class PlaywrightThread extends Thread{
    private final String browserName;

    private PlaywrightThread(String browserName) {
        this.browserName = browserName;
    }

    public static void main(String[] args) throws InterruptedException {
        // Create separate playwright thread for each browser.
        for (String browserName: asList("chromium", "webkit", "firefox")) {
            Thread thread = new PlaywrightThread(browserName);
            thread.start();
        }
    }

    @Override
    public void run() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = getBrowserType(playwright, browserName);
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            page.locator("//a[text()='Docs']").click();

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("user-agent-" + browserName + ".png")));
            System.out.println("Thread ID " + Thread.currentThread().getId() + " " + browserName);
        }
    }

    private static BrowserType getBrowserType(Playwright playwright, String browserName) {
        switch (browserName) {
            case "chromium":
                return playwright.chromium();
            case "webkit":
                return playwright.webkit();
            case "firefox":
                return playwright.firefox();
            default:
                throw new IllegalArgumentException();
        }
    }
}
