package com.bloomberg.server.arithmeticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ArithmeticServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArithmeticServiceApplication.class, args);
	}

}
