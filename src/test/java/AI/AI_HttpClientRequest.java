package AI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AI_HttpClientRequest {
    public static void main(String[] args) throws Exception {
        String apiKey = System.getenv("OPENAI_API_KEY");
        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("OPENAI_API_KEY is not set");
            return;
        }

        HttpClient client = HttpClient.newHttpClient();
        String requestBody = """
                {
                  "model": "gpt-4",
                  "messages": [
                    { "role": "system", "content": "You are a movie review expert." },
                    { "role": "user", "content": "List top 5 movies of 2025." }
                  ]
                }""";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println(response.body());
    }
}