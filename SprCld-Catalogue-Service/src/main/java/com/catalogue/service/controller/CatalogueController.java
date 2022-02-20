package com.catalogue.service.controller;

import com.catalogue.service.aop.SprCatalogeLogger;
import com.catalogue.service.model.TransactionResponse;
import com.catalogue.service.service.CatalogueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String instanceId;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private CatalogueService catalogueService;

    @SprCatalogeLogger
    @GetMapping("/getAllProducts")
    public TransactionResponse getAllProducts(@RequestHeader(value = "X-Request-routed-from") String reqRoutedFrom) {
        log.info("getAllProducts endpoint called ....instance:: " + instanceId + "  port:: " + serverPort);
        return new TransactionResponse(catalogueService.getAllProducts(), instanceId, serverPort);
    }

}
