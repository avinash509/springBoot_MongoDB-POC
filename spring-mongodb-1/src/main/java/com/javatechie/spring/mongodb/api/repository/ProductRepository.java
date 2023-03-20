package com.javatechie.spring.mongodb.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongodb.api.Entity.Product;

public interface ProductRepository extends MongoRepository<Product,Long> {
}

