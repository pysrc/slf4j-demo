package com.example.slf4jdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Slf4jDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Slf4jDemoApplication.class, args);
	}

}
