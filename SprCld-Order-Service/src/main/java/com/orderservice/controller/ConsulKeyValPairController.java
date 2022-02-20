package com.orderservice.controller;

import com.orderservice.util.OrderConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableConfigurationProperties(value = OrderConfig.class)
public class ConsulKeyValPairController {

    @Autowired
    OrderConfig config;

    @GetMapping("/props")
    public OrderConfig getProp() {
        log.info("get prop Order service called ...." + config.toString());
        return config;
    }

    @GetMapping("/getPrice")
    public String getPriceAfterDiscount(@RequestParam Integer price) {
        int discountPer = Integer.parseInt(config.getOfferDiscountPercent());
        int afterDiscountPrice = price - price * discountPer / 100;
        return "Actual price " + price + " But After Applying " + config.getOfferName() + " Your effective Price is "
                + afterDiscountPrice;
    }

}
