package com.training.microservies.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
