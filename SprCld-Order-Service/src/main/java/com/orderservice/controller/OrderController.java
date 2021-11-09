package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.model.TransactionResponse;
import com.orderservice.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

	@Value("${spring.cloud.consul.discovery.instance-id}")
	private String instanceId;

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private OrderService orderService;

	//@SprCloudLogger
	@GetMapping("/getAllProducts")
	public TransactionResponse getAllItems(	@RequestHeader(value = "X-Request-routed-from", required = false) String reqRoutedFrom) {
	//	if (null != reqRoutedFrom && reqRoutedFrom.equals("Gateway-Service")) {
			if (reqRoutedFrom.equals("Gateway-Service")) {
			log.info("getAllProducts - ORDER-SERVICE- CALLED ....");
			TransactionResponse tr = orderService.getProductList();
			tr.setInstanceId(instanceId + "  " + tr.getInstanceId());
			tr.setPort("OS port - " + serverPort + " - CS port - " + tr.getPort());
			tr.setStatusCode("200");
			return tr;
		}
		return authorizeError();
	}

	public TransactionResponse authorizeError() {
		TransactionResponse tr = new TransactionResponse();
		tr.setMessage("Failed - Authorization required");
		tr.setStatusCode("401");
		return tr;
	}

}
