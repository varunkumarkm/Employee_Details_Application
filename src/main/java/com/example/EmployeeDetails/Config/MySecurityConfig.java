//package com.example.EmployeeDetails.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//public class MySecurityConfig {
//	
////	@Bean
////	UserDetailsService userDetailsService() {
////		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
////		UserDetails user = User.withUsername("varun")
////				.password(passwordEncoder().encode("Varun@123"))
////				.authorities("read").build();
////		userDetailsService.createUser(user);
////		return userDetailsService;
////	}
//	@Bean
//	BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////		http.formLogin();
//		http.httpBasic();
////		http.authorizeHttpRequests().anyRequest().authenticated();
////		http.authorizeHttpRequests().requestMatchers("/api/employees/getAllEmployees").authenticated()
////		.anyRequest().denyAll();
//		http.authorizeHttpRequests().requestMatchers("/api/employees/createEmployee").authenticated();
//		http.authorizeHttpRequests().requestMatchers("/api/employees/getAllEmployees").authenticated();
//		http.authorizeHttpRequests().requestMatchers("/api/employees/getEmployeeById/{id}").authenticated();
//		http.addFilterBefore(new MySecurityFilter(), BasicAuthenticationFilter.class);
//		return http.build();
//		
//	}
//}
