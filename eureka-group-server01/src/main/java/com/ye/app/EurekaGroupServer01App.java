package com.ye.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaGroupServer01App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGroupServer01App.class, args);
	}
}
