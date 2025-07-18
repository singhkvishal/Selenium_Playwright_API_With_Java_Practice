package Playwright_Examples.elementLocators;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ListBox {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
        page.getByLabel("Country").selectOption("India");
        page.locator("iframe[name=\"a-sstpebfwe6vl\"]").contentFrame().getByLabel("I'm not a robot").click();

        page.pause();
    }

}