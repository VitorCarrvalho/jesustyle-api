package com.jesustyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jesustyle.application")
public class JesustyleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JesustyleApplication.class, args);
	}

}
