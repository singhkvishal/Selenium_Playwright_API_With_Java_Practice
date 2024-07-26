package Playwright_Examples.recordVideos;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class recordVideoOfTests {
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		
		Page page = brContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
		page.click("text=MacBook");
		page.click("'Add to Cart'");
		page.click("'Shopping Cart'");
		page.locator("#content").allInnerTexts().forEach(e->System.out.println(e));
		
		// Saved video files will appear in the specified folder. They all have generated unique names.
		// For the multi-page scenarios, you can access the video file associated with the page via the Page.video()
		System.out.println(page.video().path().toString());
		
		page.close();
		brContext.close();
		browser.close();
	}

	public static class RecordTracer {
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
}
