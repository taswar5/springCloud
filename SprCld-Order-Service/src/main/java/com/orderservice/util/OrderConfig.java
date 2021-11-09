package com.orderservice.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "x-sale")
@Data
public class OrderConfig {
	private String offerName;
	private String offerDiscountPercent;
}
