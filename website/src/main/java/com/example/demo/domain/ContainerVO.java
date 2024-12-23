package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContainerVO {

	String id; // 컨테이너 ID
	String port; // 항구 순서 (목적지)
	double weight; // 컨테이너 무게 (톤)
	int slotSize; // 크기 (20ft = 1, 40ft = 2)

}
