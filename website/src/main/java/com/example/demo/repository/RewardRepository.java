package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.RewardVO;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class RewardRepository {
	
	
	private final SqlSessionTemplate sql;
	
	public void getReward() {
		List<RewardVO> list = sql.selectList("RewardMapper.getReward");
		for (RewardVO rewardVO : list) {
			System.out.println(rewardVO);
		}
	}
}
