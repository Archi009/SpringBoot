package com.example.demo;

import javax.persistence.Column;
//hiberate에 연결하지 않고 JPA interface에만 연결해서 시도 해본다
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor //아무것도 없는 기본 생성자
@AllArgsConstructor //모든 요소가 있는 기본 생성자
@Entity       //테이블 생성  (연결) 
//@Builder 생성자 대신 => 여기 선언하면 모든 값에 대한 빌딩이 되고
public class Customer { //도메인
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column
	private String name;
	private String phone;
	private String addr;
	
	@Builder  // 생성자에 선언하면 필요한 값만 빌딩 시킬 수 있다 
	public Customer(String name, String phone) {
		super();
		this.name=name;
		this.phone=phone;
	}
	
}
