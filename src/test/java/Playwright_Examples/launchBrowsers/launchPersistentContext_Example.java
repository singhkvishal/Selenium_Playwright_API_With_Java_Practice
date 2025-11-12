package Playwright_Examples.launchBrowsers;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class launchPersistentContext_Example {
    @Test
    public  void CreateBrowserStorageState() {
        // Save the Browser storageState Context
        try {
            Playwright playwright = Playwright.create();
            BrowserType chromium = playwright.chromium();

            // Define the path to your user data directory.
            // You can use an empty string "" to create a temporary directory,
            // or provide a specific path like Paths.get("path/to/your/user/data/dir").
            String userDataDir = System.getProperty("user.dir") + "\\target";

            BrowserContext browserContext = chromium.launchPersistentContext(
                    Paths.get(userDataDir),
                    new BrowserType.LaunchPersistentContextOptions().setHeadless(false) // Set headless to false to see the browser UI
            );

            Page page = browserContext.newPage();
            page.navigate("https://www.google.com");
            System.out.println("Page title: " + page.title());

            // Perform actions that might create cookies or local storage data
            page.fill("textarea[name='q']", "Playwright Java");
            page.press("textarea[name='q']", "Enter");
            page.waitForURL("**/search?q=Playwright+Java**");

            // Close the context, which will also close the browser
            browserContext.close();
        }catch (Exception e){}
    }
}
