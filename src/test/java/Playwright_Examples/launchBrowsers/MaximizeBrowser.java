package Playwright_Examples.launchBrowsers;

import java.awt.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.Test;

public class MaximizeBrowser {

	@Test
	public void FullScreenWithDimension() {
		//1- You can get the screen size with the Toolkit.getScreenSize() method.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println(width + ":" + height);

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = context.newPage();
		page.navigate("http://www.amazon.com");
	}

	@org.testng.annotations.Test(priority = 0)
	public void FullScreenWithGraphicsDevice() {
		try (Playwright playwright = Playwright.create()) {
			BrowserType.LaunchOptions launchOption = new BrowserType.LaunchOptions().setHeadless(false)
					//.setDevtools(true)  has been deprecated
					//.setProxy(new Proxy("Proxy"))
					.setSlowMo(1000);

			Browser browser = playwright.chromium().launch(launchOption);
			//2- On a multi-monitor configuration you should use this :
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			int width = gd.getDisplayMode().getWidth();
			int height = gd.getDisplayMode().getHeight();
			Page page = browser.newPage(new Browser.NewPageOptions().setViewportSize(width, height)
					// .setHttpCredentials("userName", "Password")
			);
			page.navigate("https://demoqa.com");
			System.out.println(page.title());
			System.out.println(page.url());
			// assertThat(page).hasTitle(Pattern.compile("DEMOQA"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
