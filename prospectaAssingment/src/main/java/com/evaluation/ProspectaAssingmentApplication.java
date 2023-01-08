package com.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProspectaAssingmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectaAssingmentApplication.class, args);
	}

	@Bean
	public RestTemplate restTemp() {
		return new RestTemplate();
	}
	
}
