package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ContainerVO;
import com.example.demo.service.ContainerRecommendationService;

@RestController
public class ContainerRecommendationController {
	
	@Autowired
	private ContainerRecommendationService containerService;
	
	
	public void getContainerRecommendation() {
		List<ContainerVO> containers = Arrays.asList(
	            new ContainerVO("C1", "Busan", 10.5, 1),
	            new ContainerVO("C2", "Shanghai", 15.3, 2),
	            new ContainerVO("C3", "Singapore", 8.7, 1),
	            new ContainerVO("C4", "Rotterdam", 20.1, 2),
	            new ContainerVO("C5", "Los Angeles", 12.0, 1),
	            new ContainerVO("C6", "Busan", 25.4, 2),
	            new ContainerVO("C7", "Shanghai", 18.3, 1),
	            new ContainerVO("C8", "Singapore", 10.0, 1),
	            new ContainerVO("C9", "Rotterdam", 22.5, 2),
	            new ContainerVO("C10", "Los Angeles", 9.8, 1),
	            new ContainerVO("C11", "Busan", 14.3, 2),
	            new ContainerVO("C12", "Shanghai", 19.1, 1),
	            new ContainerVO("C13", "Singapore", 11.6, 1),
	            new ContainerVO("C14", "Rotterdam", 23.0, 2),
	            new ContainerVO("C15", "Los Angeles", 13.2, 1),
	            new ContainerVO("C16", "Busan", 16.5, 1),
	            new ContainerVO("C17", "Shanghai", 17.8, 2),
	            new ContainerVO("C18", "Singapore", 12.9, 1),
	            new ContainerVO("C19", "Rotterdam", 21.7, 2),
	            new ContainerVO("C20", "Los Angeles", 15.0, 1)
	        );

		 
		containerService.getContainerRecommendation(containers);
	}
	
	
	

}
