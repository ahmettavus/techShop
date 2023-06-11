package com.ecommerce.techShop;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TechShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechShopApplication.class, args);
	}
	@Bean
	public ModelMapper getModeLMapper() {
		return new ModelMapper();
	}



	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
