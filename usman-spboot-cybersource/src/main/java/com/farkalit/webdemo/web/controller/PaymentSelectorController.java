package com.farkalit.webdemo.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.web.bind.annotation.RequestParam;
//import com.azure.messaging.servicebus.ServiceBusClientBuilder;
//import com.azure.messaging.servicebus.ServiceBusMessage;
//import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.farkalit.webdemo.model.RefundVO;
import com.farkalit.webdemo.utils.JSONPojoUtil;

/**
 * @author farkalitusman
 *
 */
@RestController
public class PaymentSelectorController {

	private static final Logger LOG = LogManager.getLogger(PaymentSelectorController.class);
	
	public static final String REFUND_TOPIC_NAME = "maf-refundtopic-dev";

	@Autowired
	private JmsTemplate jmsTemplate;
	

	@GetMapping("/health")
	public String checkHealth() {
		LOG.info("Hello there from payment orchestrator service version 1.0");
		return "{\"message\", \"Hello team from payment orchestrator service version 1.0\"}";
	}

	@PostMapping("/topic/message")
	public String sendMessageToTopic(@RequestBody RefundVO refund) {
		LOG.info("Sending message refunddata :{}", refund);
		jmsTemplate.convertAndSend(REFUND_TOPIC_NAME, JSONPojoUtil.convertObjectToJson(refund));
		LOG.info("Sent message successfully to topic :{}",REFUND_TOPIC_NAME);
		return "SUCCESS_TOPIC";
	}

//	@PostMapping(value = "/queue/message", produces = "application/json")
//	public String sendMessage(@RequestParam String message) {
//		ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
//				.connectionString(configData.getCommonConnstring()).sender().queueName(configData.getUaeCybersource())
//				.buildClient();
//		senderClient.sendMessage(new ServiceBusMessage(message));
//		LOG.info("Sent a single message to the queue: {}", configData.getUaeCybersource());
//		return "SUCCESS_QUEUE";
//	}

}
