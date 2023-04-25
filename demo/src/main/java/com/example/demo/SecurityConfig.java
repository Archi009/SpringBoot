package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean // < bean id="" class="">
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		자료랑 비교해 보자 람다식으로 바꾸는것.
		http.authorizeHttpRequests((requests) -> requests
				.antMatchers("/home","/").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated())
		.formLogin(login -> login
				.defaultSuccessUrl("/home")
				.loginPage("/login")
				.usernameParameter("userid")
				.permitAll()
				)
			
		.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.permitAll()
//				.and()
//       .csrf().disable()
				;
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1234")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**");
	}
}
