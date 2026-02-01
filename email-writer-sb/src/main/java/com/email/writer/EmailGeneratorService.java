package com.email.writer;



import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


@Service
public class EmailGeneratorService {
    private final WebClient webClient;
    private final String apiKey;

    public EmailGeneratorService(WebClient.Builder webClientBuilder,
                                 @Value("${gemini.api.url}") String baseUrl,
                                 @Value("${gemini.api.key}") String geminiApikey) {
        this.apiKey = geminiApikey;
        this.webClient = webClientBuilder.baseUrl(baseUrl).build();

    }

    public String generateEmailReply(EmailRequest emailRequest){
        //Build Prompt
        String prompt= buildPrompt(emailRequest);

        //Prepare raw JSON Body
        String requestBody= String.format("""
                {
                    "contents": [
                      {
                        "parts": [
                          {
                            "text": "%s"
                          }
                        ]
                      }
                    ]
                  }
                """,prompt);

        //Send Request
        String response= webClient.post()
                .uri(uriBuilder ->uriBuilder
                        .path("/v1beta/models/gemini-3-flash-preview:generateContent")
                        .build())
                .header("x-goog-api-key",apiKey)
                .header("Content-Type: application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //Extract Response
        return extractResponseContent(response);
    }

    private String extractResponseContent(String response) {

        try {
            ObjectMapper mapper = new ObjectMapper();
           JsonNode root = mapper.readTree(response);
            return root.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }





    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("""
You are an email reply generator.

Instructions:
- Generate ONLY ONE complete email reply.
- Do NOT provide multiple options.
- Do NOT include explanations, tips, or analysis.
- Return ONLY the final email content.
- Use proper email format (Subject, greeting, body, closing).
""");

        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Tone: ").append(emailRequest.getTone()).append("\n");
        }

        prompt.append("""
Original Email:
""").append(emailRequest.getEmailContent());

        return prompt.toString();
    }


}
