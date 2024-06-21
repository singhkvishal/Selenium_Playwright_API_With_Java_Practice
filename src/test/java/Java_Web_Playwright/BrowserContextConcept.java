package Java_Web_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		LaunchOptions op = new LaunchOptions();
		op.setHeadless(false);
		Browser browser = playwright.chromium().launch(op);

		BrowserContext brcx1 = browser.newContext();
		Page p1 = brcx1.newPage();
		p1.setViewportSize(1920, 1080);

		p1.navigate("https://demoqa.com");
		p1.locator("//*[text()=\"Elements\"]").click();

		BrowserContext brcx2 = browser.newContext();
		Page p2 = brcx2.newPage();
		p2.navigate("https://demoqa.com");
 		System.out.println(p2.title());

		BrowserContext brcx3 = browser.newContext();
		Page p3 = brcx3.newPage();
		p3.navigate("http://google.com/");
		System.out.println(p3.title());

		p1.close();
		brcx1.close();

		p2.close();
		brcx2.close();

		p3.close();
		brcx3.close();
	}

}
