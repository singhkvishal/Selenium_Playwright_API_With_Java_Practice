package AI.Playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class AutoHealingBrowser implements AutoCloseable {
    private final Playwright playwright;
    private final Browser browser;
    private final Page page;
    private final Properties healed = new Properties();
    private final Path propsFile = Paths.get("healed-locators.properties");

    public AutoHealingBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        loadHealed();
    }

    public Page page() {
        return page;
    }

    // primary and fallbacks are Playwright selector strings (e.g. "css=div.foo", "xpath=//a", "text=Sign in")
    public Locator find(String primary, String... fallbacks) {
        String key = primary;

        // Try healed mapping first
        String healedSelector = healed.getProperty(key);
        if (healedSelector != null) {
            try {
                Locator healedLoc = page.locator(healedSelector);
                if (exists(healedLoc)) return healedLoc;
            } catch (Exception ignored) {}
        }

        // Try primary
        try {
            Locator primaryLoc = page.locator(primary);
            if (exists(primaryLoc)) return primaryLoc;
        } catch (Exception ignored) {}

        // Try fallbacks
        for (String f : fallbacks) {
            try {
                Locator loc = page.locator(f);
                if (exists(loc)) {
                    saveHeal(key, f);
                    return loc;
                }
            } catch (Exception ignored) {}
        }

        throw new RuntimeException("Cannot find locator: " + primary);
    }

    private boolean exists(Locator loc) {
        try {
            return loc.count() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    private synchronized void saveHeal(String original, String healedKey) {
        healed.setProperty(original, healedKey);
        storeHealed();
    }

    private void loadHealed() {
        if (Files.exists(propsFile)) {
            try (InputStream in = Files.newInputStream(propsFile)) {
                healed.load(in);
            } catch (IOException ignored) {}
        }
    }

    private void storeHealed() {
        try (OutputStream out = Files.newOutputStream(propsFile)) {
            healed.store(out, "Auto-healed locators");
        } catch (IOException ignored) {}
    }

    @Override
    public void close() {
        try { if (browser != null) browser.close(); } catch (Exception ignored) {}
        try { if (playwright != null) playwright.close(); } catch (Exception ignored) {}
    }
}
