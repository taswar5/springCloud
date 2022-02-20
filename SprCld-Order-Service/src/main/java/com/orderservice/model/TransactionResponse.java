package com.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private List<Product> list;
    private String message;
    private String statusCode;
    private String instanceId;
    private String port;

}
