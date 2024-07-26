package Playwright_Examples.handleDialogs;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class handleJSDialogsUsingOnDialogHandlerAccept {
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.onDialog(dialog -> {
			String text = dialog.message();
			System.out.println(text);
			dialog.accept("Message from Javascript alerts - SN");
			//dialog.dismiss();
		});
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		// JS Alerts, Confirm, Prompt pop ups
		
		page.click("text=Click for JS Alert");
		String result=page.textContent("#result");
		System.out.println(result);
		
		page.click("text=Click for JS Confirm");
		result=page.textContent("#result");
		System.out.println(result);
		
		page.click("text=Click for JS Prompt");
		result=page.textContent("#result");
		System.out.println(result);
		
		page.close();
		playwright.close();
		
		//Console messages
		//I am a JS Alert
		//You successfully clicked an alert
		//I am a JS Confirm
		//You clicked: Ok
		//I am a JS prompt
		//You entered: Message from Javascript alerts - SN

	}
}
