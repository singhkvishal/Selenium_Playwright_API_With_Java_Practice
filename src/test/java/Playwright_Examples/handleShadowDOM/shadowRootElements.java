package Playwright_Examples.handleShadowDOM;

import com.microsoft.playwright.*;

import java.util.List;

public class shadowRootElements {
	public static void main(String[] args) throws InterruptedException {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");

		String val = page.locator("a.back-btn").getAttribute("aria-label");
		System.out.println(val + "\n");

		page.locator("#input").fill("Java Programming");
		page.keyboard().press("Enter");

		Thread.sleep(5000);
		List<String> listText = page.locator("h2.title").allTextContents();
		listText.stream().forEach(e -> System.out.println(e));

		Locator loc = page.locator("div#placeholder img");
		int count = loc.count();

		for (int i = 0; i < count; i++) {
			System.out.println("\n" + loc.nth(i).getAttribute("src"));
			System.out.println(loc.nth(i).getAttribute("alt"));
		}

		pw.close();
	}

}
