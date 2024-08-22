package Playwright_Examples.synchronization;

import com.microsoft.playwright.*;

import java.time.Duration;

public class AutoWaitConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//text locators 
		BrowserContext browserContext = browser.newContext();

		browserContext.setDefaultTimeout(60_000);
		browserContext.setDefaultNavigationTimeout(60_000);

		Page page=browserContext.newPage();
		// Block current thread for 60s and ensure the events are dispatched.
		page.waitForTimeout(60_000);

		page.navigate("https://www.bigbasket.com/");
		page.waitForURL("https://www.bigbasket.com/");
		Locator login = page.locator("//*[text()=\"Login/ Sign Up\"]");

		System.out.println(page.locator("//*[@class=\"flex flex-row\"]").isEnabled());
		
		page.locator("//*[@id='multiform']").fill("9898989898");
		page.locator("//button[@type=\"submit\"]").click();

		page.locator("//*[text()=\"Verify Mobile Number\"]").isVisible();
	}
}
