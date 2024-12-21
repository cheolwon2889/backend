package com.example.demo.service;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAiService {
	
	@Value("${openai.api.key}")
	private String apiKey;
	
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
	
    // 작업 안됨 제미나이로 변경
    public String getChatGPTResponse(Map<String, Object> inputData) {
        RestTemplate restTemplate = new RestTemplate();

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        // 요청 본문 설정
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo"); // 모델 선택
        requestBody.put("messages", new Object[] {
        		 Map.of("role", "system", "content", "You are a maritime navigation and anchoring expert."),
                 Map.of("role", "user", "content", "Given the following data, calculate the required anchor tension and chain length:\n" + inputData.toString())
        });

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        try {
            // API 호출
            ResponseEntity<Map> response = restTemplate.exchange(
                OPENAI_API_URL,
                HttpMethod.POST,
                requestEntity,
                Map.class
            );

            // 응답 처리
            Map<String, Object> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("choices")) {
                Map<String, Object> choice = (Map<String, Object>) ((java.util.List<?>) responseBody.get("choices")).get(0);
                Map<String, Object> messageResponse = (Map<String, Object>) choice.get("message");
                return (String) messageResponse.get("content");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Unable to process the request.";
        }

        return "Error: No response from OpenAI.";
    }

}
