package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoVO {

	String cargo_id;
	String ship_id;
	String cargo_from;
	String cargo_to;
	boolean cargo_exist;
	double cargo_arrival_time;
	
}
