package com.learning.mongodemo.product.repository;

import com.learning.mongodemo.product.dto.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndsWith(String name);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findAllByOrderByIdAsc(Pageable pageable);

}
