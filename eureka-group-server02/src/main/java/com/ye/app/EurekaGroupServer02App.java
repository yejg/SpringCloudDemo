package com.ye.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaGroupServer02App {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGroupServer02App.class, args);
	}
}
