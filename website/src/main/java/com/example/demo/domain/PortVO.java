package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortVO {

	String port_id;
	Integer port_num;
	double port_length;
	double port_draft;
	ShipVO shipVO;
	ScheduleVO scheduleVO;
}
