package com.learning.mongodemo.product.repository;

import com.learning.mongodemo.product.dto.Category2;
import com.learning.mongodemo.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category2, String> {


}
