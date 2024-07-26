package Playwright_Examples.elementLocators;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class ElementsLocators {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeSuite
    public void Setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @Test
    public void multipleElementsUsingLambaForeach() {
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");
        Locator countryOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOptions.count());
        List<String> optionsTextList = countryOptions.allTextContents();
        optionsTextList.forEach(ele -> System.out.println(ele));
    }

    @Test
    public void multipleElementsUsingListFor() {
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");

        Locator countryOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOptions.count());

        List<String> optionsTextList = countryOptions.allTextContents();

        for (String e : optionsTextList)
            System.out.println(e);
    }

    @Test
    public void multipleElementsUsingNthIndex() {
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial/?");

        Locator countryOptions = page.locator("select#Form_getForm_Country option");
        System.out.println(countryOptions.count());

        for (int i = 0; i < countryOptions.count(); i++) {
            //Returns locator to the n-th matching element. It's zero based, nth(0) selects the first element.
            String text = countryOptions.nth(i).textContent();
            System.out.println(text);
        }
    }

    @Test
    public void singleElement() {
        page.navigate("https://www.orangehrm.com/");

        Locator contactSales = page.locator("text = Contact Sales");

        //contactSales.click(); -- when there are multiple elements for an Locator, then Playwright Exception is thrown

        //com.microsoft.playwright.PlaywrightException: Error {
        //Error: strict mode violation: "text= Contact Sales" resolved to 2 elements:
        //    1) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka playwright.$("text=Contact Sales >> nth=0")
        //    2) <button class="btn btn-ohrm btn-free-demo">Contact Sales</button> aka playwright.$("text=Contact Sales >> nth=1")

        //contactSales.first().click();
        contactSales.last().click();
        //using first() or last() method we can access the respective Locator elements.

        String pageUrl = page.url();
        System.out.println(pageUrl);
    }

    @Test
    public void singleElement2() {
        page.navigate("https://academy.naveenautomationlabs.com/");
        Locator login = page.locator("text=Login");
        int loginsCount = login.count();
        System.out.println(loginsCount);
        login.first().click();
    }

    @AfterSuite
    public void TearDown() {
        browser.close();
        playwright.close();
    }
}
