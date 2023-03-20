package Product.Mongodb.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Product.Mongodb.config.ProductConfiguration;
import Product.Mongodb.exception.CurrencyNotValidException;
import Product.Mongodb.exception.OfferNotValidException;

import Product.Mongodb.model.Product;
import Product.Mongodb.repository.ProductRepository;




@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ProductConfiguration config;
   
	
	public String addProduct(Product product) {
		
		if(product.getPrice()==0 && product.getDiscount()>0) {
			throw new OfferNotValidException("NO discount allowed at 0 product price");
		}
		
		//Log.info("adding product");
		
		
		if(!config.getCurrencies().contains(product.getCurrency().toUpperCase())) {
			throw new CurrencyNotValidException("Invalid Currenct. Valid Currencies-" +config.getCurrencies());
		}
		
		repo.save(product);
		return "Success";
		
	}

	public List<Product> listAllProducts() {
		
		return repo.findAll();
	}

	public List<Product> productCategoryList(String category) {
		
		return repo.findByCategory(category);
		
		/*return products.stream().filter(product ->product.getCategory().getName().equalsIgnoreCase(category))
		.collect(Collectors.toList());*/
	}

	public Product productById(Integer id) {
		
		return repo.findById(id).get();
		
		/*return products.stream().filter(product -> product.getId().equals(id))
				.findAny()
				.get();*/
		
	}

	public String UpdateProduct(Product product) {
	       
	    		   repo.save(product);
	    		   /*prod.setName(product.getName());
	    		   prod.setCategory(product.getCategory());
	    		   prod.setDiscount(product.getDiscount());
	    		   prod.setDiscountDescription(product.getDiscountDescription());*/
	    		   
	    		   return "Product Updated Successfully";    
        
	   }



	public String deleteproductById(Integer id) {
		
		repo.deleteById(id);
		/*for(Product prod : products ) {
			if(prod.getId().equals(id)) {
				products.remove(prod);
				return "product deleted";
			}
		}*/
			return "Product deleting sucess";
	
	}
}