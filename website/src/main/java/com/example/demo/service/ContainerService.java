package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ContainerRepository;

@Service("ContainerService")
public class ContainerService {
	
	@Autowired
	private ContainerRepository cRepository;
	
	public void getShipSchedule(String shipId) {
		cRepository.getShipSchedule(shipId);
	}

}
