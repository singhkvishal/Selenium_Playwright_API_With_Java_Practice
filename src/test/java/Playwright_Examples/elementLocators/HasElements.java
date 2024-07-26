package Playwright_Examples.elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class HasElements {

	@Test
	public void HasElements() {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://www.amazon.com/");

//		Locator loc = page.locator("select#Form_submitForm_Country:has(option[value='India'])");
//		loc.allInnerTexts().forEach(e -> System.out.println(e));

		Locator footerList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		footerList.allInnerTexts().forEach(e -> System.out.println(e));

	}

	@Test
	public void HasElements2() {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://dzone.com/");

		//Locator for footer which has About link
		Locator footer = page.locator("ul.link-group:has(a[href='/pages/about'])");
		footer.allInnerTexts().forEach(e -> System.out.println(e));

		System.out.println("***************************");
		//Locator for footer which has Writers Zone link
		Locator footer2 = page.locator("ul.link-group:has(a[href='/writers-zone'])");
		footer2.allInnerTexts().forEach(e -> System.out.println(e));
	}

	@Test
	public void HasElements3() {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");

		//Locator for country dropdown which has value of Australia
		Locator country = page.locator("select#Form_getForm_Country:has(option[value='Australia'])");

		country.allInnerTexts().forEach(e -> System.out.println(e));
		country.allTextContents().forEach(e -> System.out.println(e));

		pw.close();
	}
}
