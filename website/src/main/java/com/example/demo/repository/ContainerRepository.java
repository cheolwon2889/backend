package com.example.demo.repository;

import java.awt.Container;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.ContainerVO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ContainerRepository {
	
private final SqlSessionTemplate sql;
	
	public void getShipSchedule(String ship_id) {
		List<ContainerVO> list = sql.selectList("ContainerMapper.getShipSchedule", ship_id);
		for (ContainerVO vo : list) {
			System.out.println(vo);
		}
	}
	

}
