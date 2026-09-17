package com.learning.mongodemo.product.repository;

import com.learning.mongodemo.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
