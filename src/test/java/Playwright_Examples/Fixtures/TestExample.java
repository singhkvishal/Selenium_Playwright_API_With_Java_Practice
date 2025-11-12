package Playwright_Examples.Fixtures;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
class TestExample {

    @Test
    void basicTest(Page page) {
        page.navigate("https://playwright.dev/");

        assertThat(page).hasTitle(Pattern.compile("Playwright"));
    }
}