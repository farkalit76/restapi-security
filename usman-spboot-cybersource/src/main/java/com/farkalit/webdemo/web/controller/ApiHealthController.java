package com.farkalit.webdemo.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.farkalit.webdemo.model.RefundRequest;
import com.farkalit.webdemo.model.RefundResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class ApiHealthController {

	private static final Logger LOG = LogManager.getLogger(ApiHealthController.class);

	@GetMapping(value = "/health", produces = "application/json")
	public String healthCheack() {
		return "Application is ready to call the functions.";
	}

	@PostMapping(value = "/{orderId}/payment", consumes = "application/json", produces = "application/json")
	public RefundResponse sendMessageToTopic(
			@ApiParam(name = "orderId", value = "Order Id", required = true) @PathVariable final String orderId,
			@RequestHeader(required = true) String channel, 
			@RequestParam(name = "type",required = false) String type,
			@RequestBody RefundRequest request) {

		LOG.info("Refund payment input data :{}", request);
		RefundResponse response = new RefundResponse(orderId, channel, request.getAmount(), request.getRequestId());
		response.setType(type);
		return response;

	}
}
