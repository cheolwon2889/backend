package com.example.demo.domain;

import lombok.Data;
/**
 * DTO(Data Transfer Object)와 VO(Value Object)는 
 * 객체지향 프로그래밍에서 주로 사용되는 개념으로, 둘 다 데이터를 담고 전달하는 데 사용되지만, 목적과 사용 방법에서 차이가 있습니다.
 * DTO 목적
 * 데이터를 다른 계층(또는 시스템) 간에 전송하기 위한 객체입니다.
 * 주로 서비스 계층에서 데이터를 전달하거나, 외부 API 호출과 같은 작업에서 사용됩니다.
 *  
 *  특징 : 
 * 	 1. 가변성 : DTO 객체는 데이터의 값을 수정할 수 있습니다.(setter 메서드가 존재하거나, 필드가 public인 경우도 있음)
 *   2. 계층 간 데이터 전달 : 주로 ( Controller, Service, Repository 등 계층 간 데이터 교환에 사용됩니다. 
 * 
 * VO 목적
 * 특정한 값(value)을 나타내기 위해 사용하는 객체 입니다.
 * 주로 도메인 모델에서 불변성(immutable)을 보장하며, 동일한 값을 가지면 같은 객체로 간주됩니다.
 * 
 * 특징 : 
 *   1. 불변성 : VO 객체는 생성 이후 상태를 변경할 수 없습니다. (final 필드와 함께 사용)
 *   2. 동등성 비교 : VO는 객체의 메모리 주소가 아닌, 값의 동등성을 기준으로 비교합니다. (equals와 hashCode 메서드 재정의)
 * 
 */
@Data
public class MemberVO {

}
