package com.invillia.sabadell.ordercommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderCommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCommandApplication.class, args);
	}

}
