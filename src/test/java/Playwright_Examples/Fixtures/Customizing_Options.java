package Playwright_Examples.Fixtures;

import com.microsoft.playwright.*;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UsePlaywright(Customizing_Options.CustomOptions.class)

public class Customizing_Options {
    public static class CustomOptions implements OptionsFactory {
        @Override
        public Options getOptions() {
            return new Options()
                    .setHeadless(false)
                    .setContextOptions(new Browser.NewContextOptions()
                            .setBaseURL("https://github.com"))
                    .setApiRequestOptions(new APIRequest.NewContextOptions()
                            .setBaseURL("https://playwright.dev"));
        }
    }

    @Test
    public void testWithCustomOptions(Page page, APIRequestContext request) {
        page.navigate("/");
        assertThat(page).hasURL(Pattern.compile("github"));

        APIResponse response = request.get("/");
        assertTrue(response.text().contains("Playwright"));
    }
}