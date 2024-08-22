package Playwright_Examples.elementLocators;

import com.microsoft.playwright.*;
import java.util.List;

public class cssSelectors {
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setDevtools(true));

		Page page = browser.newContext().newPage();
		page.navigate("https://www.opencart.com/"); //Launches Open cart website
		//page.pause();
		browser.newContext().setDefaultTimeout(50_000);
		page.locator(".hidden-sm a:has-text('Free Download')").click(); //Finds and clicks on Free Download button
		System.out.println(page.url());  //Prints the page url of the Download

		String text = page.locator("div#steps h2").first().textContent(); //Finds text - How to install OpenCart
		System.out.println(text);
		page.pause();
		page.goBack();  //Navigate back to previous url - Open cart home page
		page.locator(".hidden-sm a:has-text('View Demo')").first().click(); //Finds and clicks on View Demo button
		System.out.println(page.url()); //Prints the page url of the Demo

		String header = page.locator("div#cms-demo h1").textContent(); //Finds text - OpenCart Demonstration
		System.out.println(header);

		List<String> boxesText = page.locator("div.demonstration-box h2").allTextContents();
		System.out.println(boxesText); // Prints text values as List - [Store Front, Administration]

		Locator imgElement = page.locator("div.demonstration-box img"); //Locator for Demonstration Box Image tagname

		for (int i = 0; i < imgElement.count(); i++) {
			String imgSourceVal = imgElement.nth(i).getAttribute("src");
			System.out.println(imgSourceVal);

			//Below src attribute is printed for the img tagname
			//application/view/image/demonstration/store-front.png
			//application/view/image/demonstration/store-admin.png
		}

		String officialDoc = page.locator("div.col-sm-12 a").textContent();
		System.out.println(officialDoc); // Prints text - Official Documentation

		pw.close();
	}
}
