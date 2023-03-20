package Product.Mongodb.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Product.Mongodb.model.Product;
import Product.Mongodb.service.ProductService;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {
	
	//Logger logger = LoggerFactory.getLogger(name: Product)
	
	@Autowired
	private ProductService service;
	


	@PostMapping("/addProduct")
	ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		service.addProduct(product);
		
		//log.info("Product added status - {}", status);
		
	return ResponseEntity.status(HttpStatus.CREATED).body(product);
}
	
	@GetMapping("/productList")
	List<Product> productList(){
		return service.listAllProducts();
	}
	
	@GetMapping("/productList/{category}")
	List<Product> productCategoryList(@PathVariable String category ){
		return service.productCategoryList(category);
	}
	
	@GetMapping("/product/{id}")
	  Product productCategoryList(@PathVariable Integer id ){
		return service.productById(id);
	}
	
	@PutMapping("/ProductUpdate")
	String UpdateProduct(@RequestBody Product product) {
		return service.UpdateProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	String deleteProductById(@PathVariable Integer id) {
		return service.deleteproductById(id);
	}
}