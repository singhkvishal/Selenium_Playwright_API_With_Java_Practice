package AI.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;

public class AutoHealingDriver {
    private final WebDriver driver;
    private final Properties healed = new Properties();
    private final Path propsFile = Paths.get("healed-locators.properties");

    public AutoHealingDriver() {
       // WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--start-maximized");
        this.driver = new ChromeDriver(opts);
       // this.driver = new ChromeDriver();
        loadHealed();
    }

    // Try the saved healed locator first (if present), then primary, then fallbacks.
    // On successful fallback, save mapping original -> healed for next runs.
    public WebElement findElement(By primary, By... fallbacks) {
        String key = stringify(primary);

        // try healed mapping
        String healedLocator = healed.getProperty(key);
        if (healedLocator != null) {
            try {
                By by = parseBy(healedLocator);
                return driver.findElement(by);
            } catch (Exception ignored) { /* fall through to try other locators */ }
        }

        // try primary
        try {
            return driver.findElement(primary);
        } catch (NoSuchElementException ignored) {}

        // try fallbacks
        for (By f : fallbacks) {
            try {
                WebElement el = driver.findElement(f);
                saveHeal(key, stringify(f));
                return el;
            } catch (NoSuchElementException ignored) {}
        }

        throw new NoSuchElementException("Cannot find element for: " + primary);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        try { driver.quit(); } catch (Exception ignored) {}
    }

    private String stringify(By b) {
        // By.toString() returns like "By.id: foo" or "By.cssSelector: .bar"
        String s = b.toString();
        if (s.startsWith("By.")) {
            int idx = s.indexOf(": ");
            if (idx > 0) {
                String type = s.substring(3, idx).trim(); // e.g., id, cssSelector, xpath
                String val = s.substring(idx + 2);
                return type + "=" + val;
            }
        }
        return s;
    }

    private By parseBy(String token) {
        int eq = token.indexOf('=');
        if (eq <= 0) {
            return By.xpath(token); // fallback
        }
        String type = token.substring(0, eq);
        String val = token.substring(eq + 1);
        switch (type) {
            case "id": return By.id(val);
            case "name": return By.name(val);
            case "className": return By.className(val);
            case "cssSelector": return By.cssSelector(val);
            case "xpath": return By.xpath(val);
            case "tagName": return By.tagName(val);
            case "linkText": return By.linkText(val);
            case "partialLinkText": return By.partialLinkText(val);
            default: return By.xpath(val);
        }
    }

    private synchronized void saveHeal(String originalKey, String healedKey) {
        healed.setProperty(originalKey, healedKey);
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
}
