package Playwright_Examples.launchBrowsers;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Proxy;
import org.testng.annotations.Test;
import java.awt.*;
import java.time.Duration;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {

    @Test(priority = 0)
    public void LaunchBrowser() {
        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions launchOption = new BrowserType.LaunchOptions().setHeadless(false)
                    //.setDevtools(true)  has been deprecated
                    //.setProxy(new Proxy("Proxy"))
                    .setSlowMo(1000);

            Browser browser = playwright.chromium().launch(launchOption);

            Dimension screensaver = Toolkit.getDefaultToolkit().getScreenSize();
            int height = (int) screensaver.getHeight();
            int width = (int) screensaver.getWidth();
            Page page = browser.newPage(new Browser.NewPageOptions().setViewportSize(width, height)
                   // .setHttpCredentials("userName", "Password")
            );
            long abc=1000;
            page.navigate("https://demoqa.com") ;
            System.out.println(page.title());
            System.out.println(page.url());
            assertThat(page).hasTitle(Pattern.compile("DEMOQA"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
