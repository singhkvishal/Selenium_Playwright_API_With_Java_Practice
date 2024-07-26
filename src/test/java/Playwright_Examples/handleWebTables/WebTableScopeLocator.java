package Playwright_Examples.handleWebTables;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebTableScopeLocator {
    Playwright playwright;
    Page page;

    @BeforeSuite
    public void Setup() {
        playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void ScopeLocator() {
        page.navigate("https://datatables.net/");

        Locator row = page.locator("table#example tr");
        Locator rowElements = row.locator(":scope", new Locator.LocatorOptions().setHasText("Bradley Greer"))
                .locator(".dt-body-right");
        rowElements.allInnerTexts().forEach(e -> System.out.println(e));

        System.out.println("*************************************");
        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
    }

    @Test
    public void ScopeLoctor2() {
        page.navigate("https://datatables.net/");
        Locator row = page.locator("p-table.p-element tr");

        row.locator(":scope", new Locator.LocatorOptions().setHasText("Lenna Paprocki"))
                .locator("div.p-checkbox-box.p-component")
                .click();

        System.out.println("*************************************");

        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
    }

    @AfterSuite
    public void TearDown() {
        page.close();
    }
}
