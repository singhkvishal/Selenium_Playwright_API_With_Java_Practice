package AI;

//https://platform.openai.com/docs/libraries?desktop-os=windows&language=java
import com.microsoft.playwright.*;
import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.chat.*;

public class AIPlaywrightDemo {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.tutorialspoint.com/selenium/practice/register.php");

            //  try {
            // 1. Attempt standard Playwright locator
            // page.click("#login-btn-old");
            // } catch (Exception e) {
            System.out.println("Selector failed. Triggering AI Healing...");

            // 2. Capture the page source for AI context
            String htmlContext = (String) page.evaluate("() => document.body.innerHTML");

            // 3. Ask AI for the new selector
            String FirstName = askAIForSelector(htmlContext, "the First Name");
            String LastName = askAIForSelector(htmlContext, "the Last Name");

            String userName = askAIForSelector(htmlContext, "the User Name");

            String password = askAIForSelector(htmlContext, "the Password");

            page.locator("css=" + FirstName).fill("John");
            page.locator("css=" + LastName).fill("Doe");
            page.locator("css=" + userName).fill("johndoe");
            page.locator("css=" + password).fill("SecurePass123");

            // 4. Heal and continue
            //page.click(newSelector);
            // System.out.println("Successfully healed using selector: " + newSelector);
            //  }
        }
    }

    private static String askAIForSelector(String html, String description) {
        String apiKey = System.getenv("OPENAI_API_KEY");
        OpenAiService service = new OpenAiService(apiKey);
        String prompt = "Given this HTML: " + html + "\n\nFind the CSS selector for " + description + ". Return ONLY the selector string.";

        ChatMessage message = new ChatMessage(ChatMessageRole.USER.value(), prompt);
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3")
                .messages(java.util.List.of(message))
                .build();

        return service.createChatCompletion(request).getChoices().get(0).getMessage().getContent();
    }
}