package com.example.demo.controller;

import java.io.Console;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RewardService;
import com.example.demo.service.WeatherDataService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/api")
	public String main() {
		return "백엔드 데이터 연결";
	}

	// 날씨 정보 json
	@GetMapping("/weather")
	public ResponseEntity<Map<String, Object>> getWeatherData() {
//		{
//		    "tide_level": "85",                // 조위 (단위: cm)
//		    "water_temp": "11.5",              // 수온 (단위: ℃)
//		    "Salinity": "18.5",                // 염분 (단위: PSU - Practical Salinity Unit)
//		    "air_temp": "3.2",                 // 기온 (단위: ℃)
//		    "air_press": "1020.2",             // 기압 (단위: hPa)
//		    "wind_dir": "310",                 // 풍향 (단위: degree, 북쪽 기준)
//		    "wind_speed": "3.2",               // 풍속 (단위: m/s)
//		    "wind_gust": "5.1",                // 돌풍 속도 (단위: m/s)
//		    "current_dir": "65",               // 유향 (단위: degree, 북쪽 기준)
//		    "current_speed": "17.9",           // 유속 (단위: cm/s)
//		    "closest_time": "2024-12-21 21:30",// 현재 시간 이후 가장 가까운 파고 관측 시간
//		    "closest_wave_height": "1.1",      // 현재 시간 이후 가장 가까운 파고 높이 (단위: m)
//		    "next_time": "2024-12-21 22:00",   // 두 번째로 가까운 파고 관측 시간
//		    "next_wave_height": "1.2"          // 두 번째로 가까운 파고 높이 (단위: m)
//		    "WH_AVE": "1.0"                    // 평균파고 (m)
//		    "WP": "5.7"                        // 파주기 (sec)
//		    "WO": "63"                        // 파향 (degree) 
//		}
		try {
			// 서비스 호출하여 데이터 가져오기
			Map<String, Object> responseData = weatherDataService.fetchAllApiData();

			// 200 OK 응답으로 반환
			return ResponseEntity.ok(responseData);
		} catch (Exception e) {
			// 예외 발생 시 500 Internal Server Error 응답
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("error", "Failed to fetch weather data.");
			errorResponse.put("details", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
	@Autowired
	private RewardService rewardService;
	
	@GetMapping("test")
	public void DBCon() {
		rewardService.printRewards();
	}



}
