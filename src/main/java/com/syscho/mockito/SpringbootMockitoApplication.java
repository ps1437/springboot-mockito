package com.syscho.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.syscho.*")
public class SpringbootMockitoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMockitoApplication.class, args);
	}

}
