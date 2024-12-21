package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String chatWithOpenAI(@RequestBody Map<String, Object> inputData) {
		return openAiService.getChatGPTResponse(inputData);
	}
	
}
