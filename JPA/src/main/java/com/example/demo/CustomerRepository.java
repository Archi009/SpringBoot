package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//제네릭 안에 테이블과 기본키를 넣어줘서 기준을 잡아준다? CRUD 처리해 줄 interface
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByPhone(String phone);
	@Query("select u from Customer u where u.name like ?1%") 
	List<Customer> findByAndSort(String name);
}
