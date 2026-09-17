package com.learning.mongodemo.product.service;

import com.learning.mongodemo.product.dto.Product;
import com.learning.mongodemo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public String save(Product product){
        return productRepository.save(product).getId();
    }

    public Product findById(String id){
        return productRepository.findById(id)
                .orElse(null);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }
}
