package Playwright_Examples.Actions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

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
    @Test
    public void LaunchChromiumBrowserWithCustomDriverPath (){
        // Create a Playwright instance
        Playwright playwright = Playwright.create();

        // Get the path to the Chrome driver
        String workingDirectory = System.getProperty("user.dir");
        // I had to copy everything in C:\Users\myUserName\AppData\Local\ms-playwright\chromium-1060\chrome-win to ArchivedPlaywrightDrivers
        Path driverPathOfChromium = Paths.get(workingDirectory, "ArchivedPlaywrightDrivers");
        // Set the path to the Chrome driver executable
        String executablePath = driverPathOfChromium.toString() + "\\chrome.exe";

        // Launch the Chrome browser using the custom driver path, with none-headless mode.
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setExecutablePath(Paths.get(executablePath)).setHeadless(false));
        // Create a new page
        Page page = browser.newPage();
        // Open a web page
        page.navigate("https://www.google.com");
        //Thread.sleep(25000);
        // Close the browser
        browser.close();
        // Close the Playwright instance
        playwright.close();
    }
}
