package com.orderservice;

import com.orderservice.controller.OrderController;
import com.orderservice.model.Product;
import com.orderservice.model.TransactionResponse;
import com.orderservice.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SprCldOrderServiceApplicationTests {

    @Autowired
    private OrderController odController;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void loadContext() {
        Product p1 = new Product(1, "Mobile", 24000, true);
        Product p2 = new Product(2, "Earphones", 345, true);

        TransactionResponse trActual = new TransactionResponse();
        trActual.setList(Arrays.asList(p1, p2));
        ResponseEntity<TransactionResponse> myEntityActual = new ResponseEntity<TransactionResponse>(trActual,
                HttpStatus.OK);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Request-routed-from", "Gateway-Service");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        Mockito.when(restTemplate.exchange("http://CATALOGUE-SERVICE/catalogue/getAllProducts", HttpMethod.GET, entity,
                TransactionResponse.class)).thenReturn(myEntityActual);
    }

    @Test
    void getAllItemsServiceSucessTest() {
        Product p1 = new Product(1, "Mobile", 24000, true);
        Product p2 = new Product(2, "Earphones", 345, true);

        TransactionResponse trExpected = new TransactionResponse();
        trExpected.setList(Arrays.asList(p1, p2));
        assertEquals(orderService.getProductList(), trExpected);
    }

    /*
     * @Test void getAllItemsControllerTest() {
     *
     * Product p1 = new Product(1, "Mobile", 24000, true); Product p2 = new
     * Product(2, "Earphones", 345, true);
     *
     * TransactionResponse trExpected = new TransactionResponse();
     * trExpected.setList(Arrays.asList(p1, p2));
     * assertEquals(odController.getAllItems("Gateway-Service"), trExpected); }
     */

    @Test
    void getAllItemsFailureTest() {
        TransactionResponse trActual = odController.getAllItems("Gateway");
        TransactionResponse trExpected = new TransactionResponse();
        trExpected.setMessage("Failed - Authorization required");
        trExpected.setStatusCode("401");
        assertEquals(trActual, trExpected);
    }

    @Test
    void test() {
        SprCldOrderServiceApplication.main(
                new String[]{"--spring.main.web-environment=false", "--spring.autoconfigure.exclude=blahblahblah",
                        // Override any other environment properties according to your needs
                });
    }

}
