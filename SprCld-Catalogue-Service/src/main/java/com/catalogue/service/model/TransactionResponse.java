package com.catalogue.service.model;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
	private List<Product>list;
	private String instanceId;
	private String port;
}
