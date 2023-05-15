package com.example.demo;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) //JUNIT ver5라이브러리 추가 해주고 사용
@SpringBootTest //스프링 컨텍스트 설정(빈등록)
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository customerRepo;
	@Test
	public void 이름검색 () {
		List<Customer> list = customerRepo.findByAndSort("길동");
		assertEquals(list.get(0).getName(), "길동");
		
	}
	
	
//	@Test 
	public void 번호검색() {
		List<Customer> list = customerRepo.findByPhone("010-2222-2222");
		assertEquals(list.get(0).getPhone(), "010-2222-2222");
	}
	
	
	//jupiter 는 junit ver5임
//	@Test
	public void 고객추가() {
		
		String name = "길동";
		String phone = "010-2222-2222";
		Customer customer = Customer.builder().name(name).phone(phone).build();
//		.save 기본키가 있으면 update 없으면 insert
		customerRepo.save(customer);
		
		List<Customer> list = customerRepo.findAll();
		System.out.println(list);
//		입력하려 했던 이름과 조회한 이름이 같다면 입려깅 잘 된것.
		assertEquals(list.get(0).getName(),name);
	}
}
