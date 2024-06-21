package Java_Web_Playwright;

import com.microsoft.playwright.*;
import java.awt.*;
import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screen_size.getWidth();
        int height = (int) screen_size.getHeight();
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("MyVideos/")) .setViewportSize(width, height));
        Page page = context.newPage();
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        page.locator("(//*[text()=\"Multiple File Upload Input\"])[2]").click();
        page.close();
    }
}
