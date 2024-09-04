package com.topia.epdms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EpdmsApiGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(EpdmsApiGatewayApplication.class, args);
	}

}
