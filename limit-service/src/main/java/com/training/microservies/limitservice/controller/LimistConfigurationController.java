package com.training.microservies.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.training.microservies.limitservice.Configuration;
import com.training.microservies.limitservice.model.LimitConfiguration;

@RestController
public class LimistConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigirations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetriveConfiguration")
	public LimitConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not avalable");
	}

	public LimitConfiguration fallbackRetriveConfiguration(){
		return new LimitConfiguration(333, 3);
	}
}
