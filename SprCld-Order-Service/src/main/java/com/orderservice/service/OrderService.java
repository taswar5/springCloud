package com.orderservice.service;

import com.orderservice.model.TransactionResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "order-service-cb-prop", fallbackMethod = "getAllItemsFallbackMethod")
    public TransactionResponse getProductList() {
        // setting of headers
        System.out.println("in getproductList method:::");
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Request-routed-from", "Order-Service");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        // end
        ResponseEntity<TransactionResponse> response = restTemplate.exchange(
                "http://CATALOGUE-SERVICE/catalogue/getAllProducts", HttpMethod.GET, entity, TransactionResponse.class);
        return response.getBody();
    }

    public TransactionResponse getAllItemsFallbackMethod(Exception e) {
        TransactionResponse tr = new TransactionResponse();
        tr.setList(null);
        tr.setMessage("Catalogue service is down for a while - Fallback method");
        tr.setStatusCode("200");
        return tr;
    }

}
