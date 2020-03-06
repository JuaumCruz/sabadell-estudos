package com.invillia.sabadell.userquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserqueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserqueryApplication.class, args);
	}

}
