package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ContainerVO;

@Service("ContainerRecommendationService")
public class ContainerRecommendationService {
	
	public void getContainerRecommendation(List<ContainerVO> ContainerList) {
		// 0. 선택한 배의 경유지,도착지를 DB에서 미리 가공된 값을 가져오는걸로
		// 1. 컨테이너 선이 경유지 도착지를 받아와야 된다. 
		// DB에서 요청을 보낼꺼 경유지+도착지 받아오기
		String route = "";
		// 경유지,,, 도착지 List로 담김
        List<String> routeList = Arrays.asList(route.split(","));
		if(routeList != null) {
			// 컨테이너 List 받아오기
			
		}
		List<String> ports = new ArrayList<>();
		
		//   하역 항구끼리 List 만듬.
		
	}
}
