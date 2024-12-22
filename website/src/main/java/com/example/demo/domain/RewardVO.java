package com.example.demo.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RewardVO {
	private String emp_id;
	private String rid;
	private String division;
	private String rname;
	private String reason;
	private Timestamp rdate;
}
