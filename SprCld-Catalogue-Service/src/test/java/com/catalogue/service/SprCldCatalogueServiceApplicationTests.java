package com.catalogue.service;

import com.catalogue.service.controller.CatalogueController;
import com.catalogue.service.model.Product;
import com.catalogue.service.model.TransactionResponse;
import com.catalogue.service.service.CatalogueService;
import com.catalogue.service.util.InitializeProducts;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SprCldCatalogueServiceApplicationTests {

    @Autowired
    private CatalogueService catalogeService;

    @Autowired
    private CatalogueController catcontroller;

    @Test
    void getAllProductsTest() {
        List<Product> list = catalogeService.getAllProducts();
        assertEquals(list, InitializeProducts.initializeAllProducts());
    }

    @Test
    void getAllProductsControllerTest() {
        List<Product> list = catalogeService.getAllProducts();
        TransactionResponse tr = catcontroller.getAllProducts("");
        tr.setInstanceId("catalogue-service-95");
        tr.setPort("5085");
        assertEquals(tr, new TransactionResponse(list, "catalogue-service-95", "5085"));
    }

    @Test
    void test() {
        SprCldCatalogueServiceApplication.main(
                new String[]{"--spring.main.web-environment=false", "--spring.autoconfigure.exclude=blahblahblah",
                        // Override any other environment properties according to your needs
                });
    }
}
