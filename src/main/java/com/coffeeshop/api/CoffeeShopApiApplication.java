package com.coffeeshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({"com.coffeeshop.api"})
public class CoffeeShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApiApplication.class, args);
	}
}
