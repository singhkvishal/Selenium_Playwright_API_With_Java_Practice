package Playwright_Examples.recordVideos;


import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Locator.ScreenshotOptions;

public class ScreenshotConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));//.setChannel("msedge"));

		Page page = browser.newPage();
		page.navigate("file:///"+System.getProperty("user.dir")+"//Logs//Installation _ Playwright Java.html");

		byte b[] = page.screenshot();

		page.locator("//*[@class=\"navbar__inner\"]").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("Resume.png")));

		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(false));

	//	page.locator("img[title='MacBook']").screenshot(new ScreenshotOptions().setPath(Paths.get("laptop.png")));

		///page.locator("div#content div.row").screenshot(new ScreenshotOptions().setPath(Paths.get("featured.png")));

	}
}
