package com.example.EmployeeDetails.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
import com.example.EmployeeDetails.Security.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	
  @Autowired
  private CustomUserDetailsService userDetailsService; //loadByUserName()
	
  @Bean
  PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
  
  
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
  }


  @SuppressWarnings({ "removal" })
  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
      http
          .csrf().disable()
          .authorizeRequests()
              .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
              .requestMatchers("/api/auth/**").permitAll()
              .anyRequest()
              .authenticated()
              .and()
          .httpBasic();
      
      return http.build();
  }
  
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService)
              .passwordEncoder(passwordEncoder());
  }


 
//  @Bean
//  protected UserDetailsService users() {
//	  UserDetails varun = User.builder().username("varunkumar").password(passwordEncoder().encode("Varun@123")).roles("USER").build();
//	  UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("Admin@123")).roles("ADMIN").build();
//	  
//	  return new InMemoryUserDetailsManager(varun, admin);  
//  }
}
