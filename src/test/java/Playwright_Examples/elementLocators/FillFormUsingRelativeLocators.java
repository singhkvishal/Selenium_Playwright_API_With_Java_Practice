package Playwright_Examples.elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FillFormUsingRelativeLocators {
	static Page page;

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		page = browser.newPage();
		page.navigate("https://www.opencart.com/index.php?route=account/register");

		page.locator("input:below(label:text('Username'))").first().fill("Vishal12312");
		page.locator("input:below(label:text('First Name'))").first().fill("Vishal");
		page.locator("input:below(label:text('Last Name'))").first().fill("Singh");
		page.locator("input:below(label:text('E-Mail'))").first().fill("vishal@gmail.com");
	}
}