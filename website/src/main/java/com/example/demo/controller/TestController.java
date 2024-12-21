package com.example.demo.controller;

import java.io.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.WeatherDataService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class TestController {
	
	@Autowired
	private WeatherDataService weatherDataService;
	
	@GetMapping("/api")
	public String main() {
		return "백엔드 데이터 연결";
	}
	
	
	
	// 날씨 정보 json
	@GetMapping("/weather")
    public Map<String, Object> getWeatherData() {
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
//		}
		
        return weatherDataService.fetchAllApiData();
    }
	

	


}
