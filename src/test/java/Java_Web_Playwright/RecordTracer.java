package Java_Web_Playwright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import java.nio.file.Paths;

public class RecordTracer {
    @Test
    public void CreateBrowserTracing() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        // Start tracing before creating / navigating a page.
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = context.newPage();
        page.navigate("https://playwright.dev");

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        playwright.close();
    }
}
// Command to Open the Trace Log
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"

//OR

//Open the below URL and browse the Trace.zip file
//https://trace.playwright.dev/