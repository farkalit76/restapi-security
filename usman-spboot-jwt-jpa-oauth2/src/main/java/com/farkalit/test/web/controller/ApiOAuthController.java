package com.farkalit.test.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiOAuthController {

	
	private static final Logger LOG = LogManager.getLogger(ApiOAuthController.class);
	
	@RequestMapping("/hello")
	public String index() {
		LOG.info("controller started...");
		return "Greetings from API OAuth implmentation!";
	}
}
