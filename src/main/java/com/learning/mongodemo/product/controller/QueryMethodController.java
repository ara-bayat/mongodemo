package com.learning.mongodemo.product.controller;


import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.service.ProductService;
import com.learning.mongodemo.product.service.QueryMethodService;
import com.learning.mongodemo.product.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
@RequiredArgsConstructor
public class QueryMethodController {

    private final QueryMethodService queryMethodService;


    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchBtName(@RequestParam("name") String name){
        return ResponseEntity.ok(queryMethodService.searchByName(name));
    }


    @GetMapping("/search/start-with")
    public ResponseEntity<List<Product>> searchByNameStartingWith(@RequestParam("name") String name){
        return ResponseEntity.ok(queryMethodService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/End-with")
    public ResponseEntity<List<Product>> searchByNameEndWith(@RequestParam("name") String name){
        return ResponseEntity.ok(queryMethodService.searchByNameEndWith(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price){
        return ResponseEntity.ok(queryMethodService.searchByPriceLt(price));
    }

    @GetMapping("/search/sort")
    public ResponseEntity<List<Product>> sortById(){
        return ResponseEntity.ok(queryMethodService.sortById());
    }





}
