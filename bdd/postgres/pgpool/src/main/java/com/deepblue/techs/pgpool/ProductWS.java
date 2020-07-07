package com.deepblue.techs.pgpool;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrés Farías (a.farias@globant.com)
 */
@RestController
public class ProductWS {

    private static final Log logger = LogFactory.getLog(ProductWS.class);

    @Autowired
    private ProductRepository repository;

    @GetMapping(path = "/random")
    public String createRandomProduct() {
        Product product = ProductFactory.randomProduct();
        product = repository.save(product);
        logger.info("Product saved=" + product.toString());

        return product.toString();
    }

    @GetMapping(path = "/products")
    public List<String> getAllProducts() {
        Iterable<Product> all = repository.findAll();
        List<String> products = new ArrayList<>();
        for (Product product : all) {
            products.add(product.toString());
        }
        logger.info("Products retrieved=" + products.size());
        return products;
    }
}
