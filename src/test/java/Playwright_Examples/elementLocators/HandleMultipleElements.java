package Playwright_Examples.elementLocators;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import java.util.List;

public class HandleMultipleElements {
    @Test
    public void HandleListOfElements() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            Page page = browser.newPage();

            page.navigate("https://practicetestautomation.com/practice-test-login/");
            page.fill("//*[@id='username']", "student");
            page.locator("//*[@id='password']").fill("Password123");

            //page.locator("//*[@id=\"submit\"]").first();
            //page.locator("//*[@id=\"submit\"]").last();
            //page.locator("//*[@id=\"submit\"]").nth(1);
            //page.locator("//*[@id=\"submit\"]").count();

            page.locator("//*[@id=\"submit\"]").click();
            List<Locator> allLocator = page.locator("//*[@id='menu-primary-items']/child::li").all();

            Locator countryOptions = page.locator("//*[@id='menu-primary-items']/child::li");
            for (int i = 0; i < countryOptions.count(); i++) {
                System.out.println(countryOptions.nth(i).textContent());
            }

            List<String> allTextCont = page.locator("//*[@id='menu-primary-items']/child::li").allTextContents();
            for (String e : allTextCont) {
                System.out.println(e);
            }
            allTextCont.forEach(ele -> System.out.println(ele));
        }
    }
}