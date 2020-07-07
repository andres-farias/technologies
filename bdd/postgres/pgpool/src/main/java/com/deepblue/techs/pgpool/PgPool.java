package com.deepblue.techs.pgpool;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * @author Andrés Farías (a.farias@globant.com)
 */
@SpringBootApplication
public class PgPool {

    private static final Log logger = LogFactory.getLog(PgPool.class);

    public static void main(String[] args) {
        SpringApplication.run(PgPool.class, args);
    }

    @Bean
    public CommandLineRunner insert(ProductRepository productRepository) {
        return (args) -> {
            Product product = ProductFactory.randomProduct();
            product = productRepository.save(product);
            logger.debug("Product persisted: " + product.toString());

            for (Product aProduct: productRepository.findAll()){
                logger.debug("Product: " + aProduct.toString());
            }

        };
    }

}
