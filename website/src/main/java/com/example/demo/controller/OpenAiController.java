package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OpenAiService;

@RestController
@RequestMapping("/api/chat")
public class OpenAiController {
	
	
	@Autowired
	private OpenAiService openAiService;
	
	
	
	// 일단 테스트로 PostMapping을 하고
	@PostMapping
    public ResponseEntity<Map<String, String>> chatWithOpenAI() {
        try {
            // 서비스에서 응답 텍스트 가져오기
            String responseText = openAiService.getGeminiResponse();

            // Map으로 응답 구성
            Map<String, String> responseMap = Map.of("text", responseText);

            return ResponseEntity.ok(responseMap);
        } catch (Exception e) {
            // 예외 발생 시 에러 응답
            Map<String, String> errorMap = Map.of(
                "text", "Error: " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
        }
    }
	
}
