package com.practice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EmployeeConfiguration {

	@Bean
	public SecurityFilterChain employeeSecurityFilter(HttpSecurity http)throws Exception
	{
		http.authorizeHttpRequests( (auth)->auth
				.requestMatchers("/masai/welcomeP").authenticated()
				.requestMatchers("/masai/employee/admin").hasRole("admin")
				.requestMatchers("/masai/welcome","/masai/employee/register").permitAll()
		).csrf().disable()
		.httpBasic();

		return http.build();
		
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	
}
