package com.eureka.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaApigateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApigateWayApplication.class, args);
	}

}
