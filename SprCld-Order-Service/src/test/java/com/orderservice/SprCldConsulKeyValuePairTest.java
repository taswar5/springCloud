package com.orderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.orderservice.controller.ConsulKeyValPairController;
import com.orderservice.util.OrderConfig;

@SpringBootTest
public class SprCldConsulKeyValuePairTest {

	@Autowired
	private ConsulKeyValPairController consulKeyValPairController;

	@Test
	void getPriceAfterDiscount() {
		String actualResp = consulKeyValPairController.getPriceAfterDiscount(100);
		String ExpectRes = "Actual price 100 But After Applying Diwali Sale Your effective Price is 70";
		assertEquals(actualResp, ExpectRes);
	}

	@Test
	void getpropsTest() {
		OrderConfig actualRes = consulKeyValPairController.getProp();
		OrderConfig expectedRes = new OrderConfig();
		expectedRes.setOfferName("Diwali Sale");
		expectedRes.setOfferDiscountPercent("30");

		assertEquals(expectedRes, actualRes);

	}

}
