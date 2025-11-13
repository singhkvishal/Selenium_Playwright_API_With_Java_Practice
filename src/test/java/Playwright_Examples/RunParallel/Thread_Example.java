package Playwright_Examples.RunParallel;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;
import static java.util.Arrays.asList;

public class Thread_Example extends Thread {
    private final String browserName;

    public Thread_Example(String browserName) {
        this.browserName = browserName;
    }

    public static void main(String[] args) throws InterruptedException {
        // Create separate playwright thread for each browser.
        for (String browserName : asList("chromium", "webkit", "firefox")) {
            Thread thread = new Thread_Example(browserName);
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
        return switch (browserName) {
            case "chromium" -> playwright.chromium();
            case "webkit" -> playwright.webkit();
            case "firefox" -> playwright.firefox();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        };
    }
}
