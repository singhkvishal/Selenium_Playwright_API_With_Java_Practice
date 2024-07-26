package Playwright_Examples.handleFrames;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HandleFrames {
    Page page;

    @BeforeSuite
    public void Setup() {
        Playwright playewright = Playwright.create();
        Browser browser = playewright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void frameLocatorMethod() {
        page.navigate("http://www.londonfreelance.org/courses/frames/index.html");
        String str = page.frameLocator("frame[name='main']").locator("h2").textContent();
        System.out.println(str);
    }

    @Test
    public void frameUsingId() {
        page.navigate("https://demoqa.com/frames");
        String str = page.frameLocator("#frame2").locator("h1").textContent();
        System.out.println(str);
    }

    @Test
    public void frameUsingName() {
        page.navigate("http://www.londonfreelance.org/courses/frames/index.html");
        Frame frame = page.frame("main");
        String st = frame.locator("h2").textContent();
        System.out.println(st);
    }

    @Test
    public void frameUsingXpath() {
        page.navigate("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");
        page.locator("img[title='Club Signup Forms and Templates']").click();
        page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("#RESULT_TextField-2").fill("PlaywrightAutomation");
    }

    @Test
    public void HandleFrame(){
        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        page.locator("img[title='vehicle-registration-forms-and-templates']").click();

        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8")
                .fill("Vishal Automation");
    }
    @AfterSuite
    public void TearDown() {
        page.close();
    }
}