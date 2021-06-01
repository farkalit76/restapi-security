package com.farkalit.test.web.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloUsmanController {
	
	private static final Logger LOG = LogManager.getLogger(HelloUsmanController.class);

	@GetMapping( value = "/hello", produces = "application/json")
	public String sayHello() {
		LOG.info("sayHello....");
		return "Hello Usman!!!";
	}
}
