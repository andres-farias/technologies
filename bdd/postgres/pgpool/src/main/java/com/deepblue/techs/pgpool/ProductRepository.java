package com.deepblue.techs.pgpool;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This class implements the CRUD operations for the Product persistence aspect.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
}
