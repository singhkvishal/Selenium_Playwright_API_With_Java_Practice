package Java_Web_Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoWaitConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		//text locators 
		Page page = browser.newPage();
		// Block current thread for 60s and ensure the events are dispatched.
		page.waitForTimeout(60_000);
		page.navigate("https://www.bigbasket.com/");
		Locator login = page.locator("//*[text()=\"Login/ Sign Up\"]");
		login.click();
		System.out.println(page.locator("//*[@class=\"flex flex-row\"]").isEnabled());
		
		page.locator("//*[@id='multiform']").fill("9898989898");
		page.locator("//button[@type=\"submit\"]").click();

		page.locator("//*[text()=\"Verify Mobile Number\"]").isVisible();
		
	}
}
