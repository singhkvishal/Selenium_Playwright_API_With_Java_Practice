package Playwright_Examples.Actions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Input_Actions {
    @Test
    public void testInputActions() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Hide")).click();

        assertEquals("Web Table Fixed header", page.getByText("Web Table Fixed header").textContent());

   // page.pause();
        //2- Select values from list box
        // Single selection matching the value or label
        page.locator("#dropdown-class-example").selectOption("option1");
        page.locator("#dropdown-class-example").selectOption("option3");

        // Single selection matching the label
        page.getByTestId("dropdown-class-example").selectOption(new SelectOption().setLabel("Option 2"));

        // Multiple selected items
       // page.getByTestId("dropdown-class-example").selectOption(new String[] {"red", "green", "blue"});
        page.pause();
    }
}
