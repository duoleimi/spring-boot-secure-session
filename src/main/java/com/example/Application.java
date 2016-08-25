package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.config.SecurityConfig;

@SpringBootApplication
public class Application {

	@Bean
	public SecurityConfig applicationSecurity() {
		return new SecurityConfig();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
