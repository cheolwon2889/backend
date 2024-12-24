package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import com.example.demo.domain.PortVO;
import com.example.demo.domain.RewardVO;
import com.example.demo.domain.ScheduleVO;

@Repository
@RequiredArgsConstructor
public class PortRepository {
	
	private final SqlSessionTemplate sql;
	
	public List<PortVO> selectPort() {
		return sql.selectList("PortMapper.selectPort");
	}
}
