package com.training.microservices.currencyconvertionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.training.microservices.currencyconvertionservice")
public class CurrencyConvertionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertionServiceApplication.class, args);
	}

}
