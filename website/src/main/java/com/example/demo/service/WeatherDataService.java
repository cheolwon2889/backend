package com.example.demo.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherDataService {

	// "부산항신항",
	// tide_level = 조위, water_temp = 수온, Salinity = 염분, air_temp = 기온, air_press =
	// 기압, wind_dir = 풍향, wind_speed = 풍속, wind_gust = 돌풍
	// http://www.khoa.go.kr/api/oceangrid/tideObsRecent/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=DT_0056&ResultType=json

	// "부산항신항"
	// current_dir = 유향, current_speed = 유속,
	// http://www.khoa.go.kr/api/oceangrid/buObsRecent/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=TW_0086&ResultType=json

	// wave_height = 파고
	// http://www.khoa.go.kr/api/oceangrid/obsWaveHight/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=KG_0024&Date=20241221&ResultType=json
	
	private final String firstApiUrl = "http://www.khoa.go.kr/api/oceangrid/tideObsRecent/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=DT_0056&ResultType=json";
	private final String secondApiUrl = "http://www.khoa.go.kr/api/oceangrid/buObsRecent/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=TW_0086&ResultType=json";
	private final String baseThirdApiUrl = "http://www.khoa.go.kr/api/oceangrid/obsWaveHight/search.do?ServiceKey=DQNqUDCwKpopPLahHEwpkg==&ObsCode=KG_0024&ResultType=json";

	public Map<String, Object> fetchAllApiData() {
		Map<String, Object> result = new HashMap<>();

		// 첫 번째 API 호출
		fetchFirstApiData(result);

		// 두 번째 API 호출
		fetchSecondApiData(result);

		// 세 번째 API 호출
		fetchThirdApiData(result);
		
		fetchFourthApiData(result);

		return result;
	}

	private void fetchFirstApiData(Map<String, Object> result) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			String response = restTemplate.getForObject(firstApiUrl, String.class);

			if (response != null) {
				JSONObject jsonResponse = new JSONObject(response);
				JSONObject data = jsonResponse.getJSONObject("result").getJSONObject("data");

				result.put("tide_level", data.optString("tide_level", "null")); // 조위
				result.put("air_temp", data.optString("air_temp", "null")); // 기온
				result.put("air_press", data.optString("air_press", "null")); // 기압
				result.put("wind_dir", data.optString("wind_dir", "null")); // 풍향
				result.put("wind_speed", data.optString("wind_speed", "null")); // 풍속
				result.put("wind_gust", data.optString("wind_gust", "null")); // 돌풍
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error_first_api", "첫 번째 API 호출 실패 또는 데이터 처리 오류");
		}
	}

	private void fetchSecondApiData(Map<String, Object> result) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			String response = restTemplate.getForObject(secondApiUrl, String.class);

			if (response != null) {
				JSONObject jsonResponse = new JSONObject(response);
				JSONObject data = jsonResponse.getJSONObject("result").getJSONObject("data");

				result.put("current_dir", data.optString("current_dir", "null")); // 유향
				result.put("current_speed", data.optString("current_speed", "null")); // 유속
				result.put("Salinity", data.optString("Salinity", "null")); // 염분
				result.put("water_temp", data.optString("water_temp", "null")); // 수온
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error_second_api", "두 번째 API 호출 실패 또는 데이터 처리 오류");
		}
	}

	private void fetchThirdApiData(Map<String, Object> result) {
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	        // 오늘 날짜 설정
	        String today = LocalDate.now().toString().replace("-", ""); // YYYYMMDD 형식
	        String apiUrl = baseThirdApiUrl + "&Date=" + today;
	        System.out.println("API URL: " + apiUrl);

	        String response = restTemplate.getForObject(apiUrl, String.class);

	        if (response != null) {
	            JSONObject jsonResponse = new JSONObject(response);
	            JSONArray dataArray = jsonResponse.getJSONObject("result").getJSONArray("data");

	            if (dataArray.length() == 0) {
	                System.out.println("No data available.");
	                result.put("closest_time", "null");
	                result.put("closest_wave_height", "null");
	                result.put("next_time", "null");
	                result.put("next_wave_height", "null");
	                return;
	            }

	            // 마지막 인덱스 계산
	            int lastIndex = dataArray.length() - 1;

	            // 현재 시간 데이터 (마지막에서 -1)
	            JSONObject closestData = dataArray.getJSONObject(lastIndex - 1);
	            String closestTime = closestData.getString("record_time");
	            String closestWaveHeight = closestData.getString("wave_height");

	            // 다음 시간 데이터 (마지막 인덱스)
	            JSONObject nextData = dataArray.getJSONObject(lastIndex);
	            String nextTime = nextData.getString("record_time");
	            String nextWaveHeight = nextData.getString("wave_height");

	            // 결과 저장
	            result.put("closest_time", closestTime);
	            result.put("closest_wave_height", closestWaveHeight);
	            result.put("next_time", nextTime);
	            result.put("next_wave_height", nextWaveHeight);

	            System.out.println("Closest Time: " + closestTime + ", Wave Height: " + closestWaveHeight);
	            System.out.println("Next Time: " + nextTime + ", Wave Height: " + nextWaveHeight);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        result.put("error_third_api", "세 번째 API 호출 실패 또는 데이터 처리 오류: " + e.getMessage());
	    }
	}
	
	 private void fetchFourthApiData(Map<String, Object> result) {
        // 네 번째 API 데이터 처리 로직 추가
		 try {
			 
			 // 현재 시간 계산
	            Calendar calendar = Calendar.getInstance();
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
	            String baseTime = dateFormat.format(calendar.getTime());

	            int minute = calendar.get(Calendar.MINUTE);
	            String roundedMinute = (minute < 30) ? "00" : "30";

	            
				String baseURL = "https://apihub.kma.go.kr/api/typ01/url/kma_buoy.php";
				String tm = baseTime + roundedMinute;
				String stn = "22104";
				String authKey = "bbldb-BeTAW5XW_gXnwFVg";

				// URL 생성
				String encodedAuthKey = URLEncoder.encode(authKey, "UTF-8");
				String fullURL = String.format("%s?tm=%s&stn=%s&help=0&authKey=%s", baseURL, tm, stn, encodedAuthKey);
				URL url = new URL(fullURL);

				// HTTP 연결
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json");

				// 응답 처리
				int responseCode = con.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// API 응답 결과를 출력합니다.
					String apiResponse = response.toString();
					
					// 고정된 값 가져오기
					String last21 = apiResponse.substring(apiResponse.length() - 21);

			        // 값 추출 및 변수 저장
			        String value1 = last21.substring(0, 3).trim(); // "1.0"
			        String value2 = last21.substring(5, 9).trim(); // "5.7"
			        String value3 = last21.substring(11, 13).trim(); // "60"
			        
			        // 값 담기
			        result.put("WH_AVE", value1);
		            result.put("WP", value2);
		            result.put("WO", value3);
			        
				} else {
					System.out.println("GET request failed. HTTP response code: " + responseCode);
				}
				con.disconnect(); // 연결 해제
			} catch (Exception e) {
				e.printStackTrace();
			}
    }

	 

	// 닻의 장력 계산
	// 필요 데이터 : 유속 및 방향, 수심, 선박의 크기, 무게, 풍압 면적, 파고(파고 (Wave Height),파주기 (Wave
	// Period)파장 (Wave Length)수심 (Depth),)
}
