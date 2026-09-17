package com.learning.mongodemo.product.service;

import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class QueryMethodService {
    private final ProductRepository productRepository;

    public List<Product> searchByName(String name){
        return productRepository.findByNameIgnoreCase(name);
    }

    public List<Product> searchByNameStartingWith(String name){
        return productRepository.findByNameStartsWith(name);
    }

    public List<Product> searchByNameEndWith(String name){
        return productRepository.findByNameEndsWith(name);
    }

    public List<Product> searchByPriceLt(BigDecimal price){
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> sortById(){
        Pageable pageable = PageRequest.of(0, 3);
        return productRepository.findAllByOrderByIdAsc(pageable);
    }


}
