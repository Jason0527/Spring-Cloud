package com.jason;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class InfoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoServerApplication.class, args);
	}

}

