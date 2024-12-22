package com.example.demo.service;




import java.util.HashMap;
import java.util.List;
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
	
	//@Value("${openai.api.key}")
	//private String apiKey;
	
     
     private static final String GEMINI_API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=????";
	
     
//     Response Body: {candidates=[{content={parts=[{text=50,000톤급 화물선의 정박을 위해서는 안전성을 최우선으로 고려해야 합니다.  제공된 정보만으로 정확한 닻의 무게와 케이블 종류를 결정하기는 어렵지만,  안전 여유를 고려하여 다음과 같은 권장 사항을 제시합니다.
//
//    		 **닻 무게:**
//
//    		 50,000톤급 화물선의 경우,  풍속 12m/s, 파고 1.8m, 유속 3.5노트의 상황을 고려하면 **최소 20톤 이상의 닻**을 사용하는 것이 안전합니다.  더 큰 안전 여유를 위해서는 **25톤 이상의 닻**을 권장합니다.  단,  정확한 닻 무게는 선박의 설계,  닻의 형태 (예: Hall 닻, Bruce 닻 등),  해저 지질 등 여러 요소를 고려하여 전문 해양 엔지니어의 계산을 통해 결정해야 합니다.  제시된 정보만으로는 정확한 계산이 불가능합니다.
//
//    		 **케이블 종류 및 사양:**
//
//    		 케이블은 고장력, 내마모성, 내식성이 뛰어난 재질이어야 합니다.  일반적으로 다음과 같은 종류가 고려됩니다.
//
//    		 * **와이어 로프 (Wire Rope):** 강철 와이어로 제작되어 강도가 높고 내구성이 뛰어납니다.  가장 일반적으로 사용되는 케이블이며,  다양한 규격으로 생산됩니다.  50,000톤급 화물선의 경우,  **직경이 50mm 이상의 고장력 와이어 로프**를 사용하는 것이 적합합니다.
//
//    		 * **합성섬유 로프 (Synthetic Fiber Rope):** 와이어 로프에 비해 가볍고 유연하며, 충격 흡수력이 우수합니다.  하지만 내마모성과 내구성이 와이어 로프보다 떨어질 수 있습니다.  합성섬유 로프를 사용할 경우,  와이어 로프보다 더 두꺼운 규격을 사용해야 안전성을 확보할 수 있습니다.
//
//
//    		 **추가 고려 사항:**
//
//    		 * **해저 지질:** 해저 지질이 모래나 진흙인 경우,  닻이 잘 박히지 않을 수 있으므로 더 무거운 닻이 필요할 수 있습니다.  반대로 암반 지대인 경우,  닻이 잘 박히므로 상대적으로 가벼운 닻을 사용할 수도 있습니다.
//    		 * **닻의 개수:** 일반적으로 대형 화물선은 2개 이상의 닻을 사용합니다.
//    		 * **케이블 길이:** 케이블의 길이는 수심,  유속,  풍속 등을 고려하여 충분한 여유를 두고 결정해야 합니다.
//
//    		 **결론적으로:**  제공된 정보만으로는 정확한 닻의 무게와 케이블 종류를 결정할 수 없습니다.  **전문 해양 엔지니어의 정확한 계산 및 평가가 반드시 필요합니다.**  안전 운항을 위해서는 이러한 전문가의 의견을 반영하여 적절한 장비를 선택하고 사용해야 합니다.
//    		 }], role=model}, finishReason=STOP, avgLogprobs=-0.174420478040738}], usageMetadata={promptTokenCount=164, candidatesTokenCount=802, totalTokenCount=966}, modelVersion=gemini-1.5-flash}

     
     
     // 제미나이로 변경
     public String getGeminiResponse() {
         // RestTemplate for HTTP requests
         RestTemplate restTemplate = new RestTemplate();

         // Headers for the request
         HttpHeaders headers = new HttpHeaders();
         headers.set("Content-Type", "application/json");

         // Create parts (text content for the request)
         Map<String, Object> parts = Map.of(
             "text", "너는 항만 운영 관리자야. 정박 조건은 다음과 같아:\n"
                     + "- 선박 종류: 화물선\n"
                     + "- 선박 중량: 50000톤\n"
                     + "- 선박 길이: 200미터\n"
                     + "- 유속: 3.5노트\n"
                     + "- 풍속: 12m/s\n"
                     + "- 파고: 1.8미터\n"
                     + "- 파주기: 6초\n"
                     + "- 수심: 30미터\n"
                     + "- 정박 면적: 10000제곱미터\n\n"
                     + "이 조건에서 몇 톤짜리 닻을 사용해야 하며, 어떤 종류의 케이블이 적합한지 알려줘."
         );

         // Create contents (array containing parts)
         List<Map<String, Object>> contents = List.of(Map.of("parts", parts));

         // Create generationConfig
         Map<String, Object> generationConfig = Map.of(
             "candidate_count", 1,
             "max_output_tokens", 1000,
             "temperature", 0.7
         );

         // Combine into the request body
         Map<String, Object> requestBody = new HashMap<>();
         requestBody.put("contents", contents);
         requestBody.put("generationConfig", generationConfig);

         // Create HTTP request entity
         HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

         try {
             // Make the API call
             ResponseEntity<Map> response = restTemplate.exchange(
                 GEMINI_API_URL,
                 HttpMethod.POST,
                 requestEntity,
                 Map.class
             );

             // Extract and return the response body
             Map<String, Object> responseBody = response.getBody();
             System.out.println("Response Body: " + responseBody);

             if (responseBody != null && responseBody.containsKey("candidates")) {
                 List<Map<String, Object>> candidates = (List<Map<String, Object>>) responseBody.get("candidates");
                 if (!candidates.isEmpty()) {
                     Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                     List<Map<String, Object>> partsList = (List<Map<String, Object>>) content.get("parts");
                     if (!partsList.isEmpty()) {
                         return (String) partsList.get(0).get("text");
                     }
                 }
             }
             return "No candidates or output found in the response.";
         } catch (Exception e) {
             e.printStackTrace();
             return "Error: Unable to process the request.";
         }
     }

}
