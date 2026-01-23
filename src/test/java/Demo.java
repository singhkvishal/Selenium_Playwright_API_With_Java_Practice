import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Demo {
    @Test
    public void Test1(){
        Playwright playwright=Playwright.create();
        BrowserType chromium = playwright.chromium();

        // Launch the browser (headless mode by default)
        Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));

        // Create a new isolated browser context
        BrowserContext context = browser.newContext();

        // Create a new page within the context
        Page page = context.newPage();

        // Navigate to a website
        page.navigate("https://www.investec.com");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept all cookies")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Read the fraud alert")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("About us")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Find out more")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Explore our history")).click();
        assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("year logo animation gif"))).isVisible();
        page.locator("iframe[title=\"Interactive or visual content\"]").contentFrame().locator("div").filter(new Locator.FilterOptions().setHasText("1974: Origins Investec Bank")).nth(2).click();
        assertThat(page.locator("iframe[title=\"Interactive or visual content\"]").contentFrame().locator("div").filter(new Locator.FilterOptions().setHasText("1974: Origins Investec Bank")).nth(2)).isVisible();
    }

}
