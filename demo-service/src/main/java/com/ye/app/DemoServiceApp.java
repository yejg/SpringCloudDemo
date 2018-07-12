package com.ye.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApp.class, args);
	}
}
