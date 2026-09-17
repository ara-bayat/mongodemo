package com.learning.mongodemo.product.service;


import com.learning.mongodemo.product.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor

public class SearchService {
    private final MongoTemplate mongoTemplate;

    public List<Product> searchByName(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameStartingWith(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^"+name));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByNameEndWith(String name){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name+"$"));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> searchByPriceLt(BigDecimal price){
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lt(price));
        return mongoTemplate.find(query, Product.class);
    }

    public List<Product> sortById(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "id")).with(PageRequest.of(0, 5));
        return mongoTemplate.find(query, Product.class);
    }

}
