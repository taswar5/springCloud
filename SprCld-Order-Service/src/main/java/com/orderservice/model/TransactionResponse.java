package com.orderservice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private List<Product>list;
	private String message;
	private String statusCode;
	private String instanceId;
	private String port;
	
}
