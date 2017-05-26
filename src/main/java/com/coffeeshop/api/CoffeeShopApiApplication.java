package com.coffeeshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({"com.coffeeshop.api.dao", "com.coffeeshop.api.service", "com.coffeeshop.api.controller"})
public class CoffeeShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeShopApiApplication.class, args);
	}
}
