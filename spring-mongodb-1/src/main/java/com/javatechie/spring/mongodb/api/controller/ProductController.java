package com.javatechie.spring.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.spring.mongodb.api.Entity.Product;
import com.javatechie.spring.mongodb.api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {


    
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
              service.create(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existproduct=service.get(id);
         service.save(existproduct);
        
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }
}

