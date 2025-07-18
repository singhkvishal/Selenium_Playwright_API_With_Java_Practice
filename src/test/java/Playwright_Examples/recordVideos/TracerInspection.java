package Playwright_Examples.recordVideos;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class TracerInspection {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			
			// Start tracing before creating / navigating a page.
			context.tracing().start(new Tracing.StartOptions()
			  .setScreenshots(true)
			  .setSnapshots(true));

			// Open new page
			Page page = context.newPage();

			// Go to https://academy.naveenautomationlabs.com/
			page.navigate("https://academy.naveenautomationlabs.com/");

			//page.pause();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").click();
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").fill("vishal singh");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").press("Tab");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").fill("vishalsingh@gmail.com");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").press("Tab");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").fill("123456");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").press("Tab");
			page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON).first().press("Tab");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").fill("+91 98749-2342");
			page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").press("Tab");
			page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
			// Stop tracing and export it into a zip archive.
			context.tracing().stop(new Tracing.StopOptions()
			  .setPath(Paths.get("trace.zip")));
		}
	}
}