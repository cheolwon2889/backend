package com.example.demo.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVO {

	String port_id;
	String ship_id;
	Timestamp arrival_time; 
	Timestamp departure_time; 

}
