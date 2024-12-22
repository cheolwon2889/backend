package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RewardVO;
import com.example.demo.repository.RewardRepository;

@Service("RewardService")
public class RewardService {
	
	@Autowired
	private RewardRepository rewardRepository;
	
	 public void printRewards() {
        rewardRepository.getReward();
     }
}
