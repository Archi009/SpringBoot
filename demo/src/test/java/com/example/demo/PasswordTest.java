package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
	
	@Test
	public void paaEncrypt() {
		
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String password = bcrypt.encode("1111");
		System.out.println(password);
//		bcrypt.matches(password, password);
	}
}
