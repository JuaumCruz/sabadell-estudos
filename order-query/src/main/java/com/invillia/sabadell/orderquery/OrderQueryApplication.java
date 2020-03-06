package com.invillia.sabadell.orderquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderQueryApplication.class, args);
	}

}
