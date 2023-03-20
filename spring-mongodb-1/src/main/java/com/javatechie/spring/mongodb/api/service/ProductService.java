package com.javatechie.spring.mongodb.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.spring.mongodb.api.Entity.Product;
import com.javatechie.spring.mongodb.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll()
	{
		return repo.findAll();
	}
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	public void create(Product product)
	{
		 repo.save(product);
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
