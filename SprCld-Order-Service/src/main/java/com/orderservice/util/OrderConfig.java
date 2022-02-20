package com.orderservice.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "x-sale")
@Data
public class OrderConfig {
    private String offerName;
    private String offerDiscountPercent;
}
