package Playwright_Examples.elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;

public class CommaSelectors {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setIgnoreDefaultArgs(List.of("--mute-audio")));

		Page page = browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com");

		//text locators
		Locator imp_ele = page.locator("span:has-text('Store'), span:has-text('signin'), a:has-text('EXPLORE COURSES')");

		System.out.println(imp_ele.count());

		if (imp_ele.count() == 3) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
}