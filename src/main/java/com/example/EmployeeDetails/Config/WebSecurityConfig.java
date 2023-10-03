package com.example.EmployeeDetails.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	
  @Bean
  PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}

  @SuppressWarnings({ "removal" })
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
      http
          .csrf().disable()
          .authorizeRequests()
              .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
              .anyRequest().authenticated()
              .and()
          .httpBasic();
      
      return http.build();
  }
  
  @Bean
  protected UserDetailsService users() {
	  UserDetails varun = User.builder().username("varunkumar").password(passwordEncoder().encode("Varun@123")).roles("USER").build();
	  UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("Admin@123")).roles("ADMIN").build();
	  
	  return new InMemoryUserDetailsManager(varun, admin);  
  }
}
