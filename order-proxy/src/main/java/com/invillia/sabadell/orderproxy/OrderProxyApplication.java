package com.invillia.sabadell.orderproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProxyApplication.class, args);
	}

}
