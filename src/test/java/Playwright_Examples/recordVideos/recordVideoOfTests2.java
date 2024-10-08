package Playwright_Examples.recordVideos;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class recordVideoOfTests2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext brContext = browser.newContext(new Browser
															.NewContextOptions()
															.setRecordVideoDir(Paths.get("videos/")));
		
		Page page = brContext.newPage();
		page.navigate("https://www.facebook.com/");
		
		page.locator("[name='email']").fill("testuser007@mail.com");
		page.locator("#pass").fill("ASDFlkj1234");
		
		page.click("text=Create New Account");
		
		page.locator("[aria-label='First name']").fill("Test1");
		page.locator("[aria-label='Surname']").fill("Test2");
		page.locator("[aria-label='Mobile number or email address']").fill("testemailaddr@gmail.com"+"");
		page.locator("[aria-label='New password']").fill("QWERTY98765");
		page.locator("[aria-label='Re-enter email address']").fill("testemailaddr@gmail.com");
		page.click("'Male'");
		
		page.click("[name='websubmit']");
		
		// Saved video files will appear in the specified folder. They all have generated unique names.
		// For the multi-page scenarios, you can access the video file associated with the page via the Page.video()
		System.out.println(page.video().path().toString());
		
		page.close();
		brContext.close();
		browser.close();
	}

}
