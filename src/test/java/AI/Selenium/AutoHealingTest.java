package AI.Selenium;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutoHealingTest {
    @Test
    public void demoAutoHealing() {
        AutoHealingDriver ah = new AutoHealingDriver();
        try {
            ah.getDriver().get("https://example.com");

            // Primary locator likely to fail; provide fallbacks. When a fallback succeeds,
            // the mapping original -> healed is saved to healed-locators.properties.
            WebElement el = ah.findElement(
                    By.id("nonexistent-id"),
                    By.cssSelector("h1"),
                    By.xpath("//h1")
            );

            System.out.println("Found text: " + el.getText());
        } finally {
            ah.quit();
        }
    }
}
