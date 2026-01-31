package AI.Playwright;


import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AutoHealingTest {
    private AutoHealingBrowser ab;

    @BeforeEach
    void setUp() {
        ab = new AutoHealingBrowser();
    }

    @AfterEach
    void tearDown() {
        ab.close();
    }

    @Test
    void exampleAutoHeal() {
        Page page = ab.page();
        page.navigate("https://example.com");

        // primary selector that may change; fallbacks that are more resilient
        Locator link = ab.find("text=Learn More", "css=a", "xpath=//a[contains(text(),'More')]");
        assertNotNull(link);
        assertTrue(link.isVisible());
        link.click();


    }
}
