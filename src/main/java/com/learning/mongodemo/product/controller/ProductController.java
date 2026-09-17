package com.learning.mongodemo.product.controller;


import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.repository.ProductRepository;
import com.learning.mongodemo.product.service.ProductService;
import com.learning.mongodemo.product.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final SearchService  searchService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable String id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search/is")
    public ResponseEntity<List<Product>> searchBtName(@RequestParam("name") String name){
        return ResponseEntity.ok(searchService.searchByName(name));
    }


    @GetMapping("/search/start-with")
    public ResponseEntity<List<Product>> searchByNameStartingWith(@RequestParam("name") String name){
        return ResponseEntity.ok(searchService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/End-with")
    public ResponseEntity<List<Product>> searchByNameEndWith(@RequestParam("name") String name){
        return ResponseEntity.ok(searchService.searchByNameEndWith(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price){
        return ResponseEntity.ok(searchService.searchByPriceLt(price));
    }

    @GetMapping("/search/sort")
    public ResponseEntity<List<Product>> sortById(){
        return ResponseEntity.ok(searchService.sortById());
    }





}
