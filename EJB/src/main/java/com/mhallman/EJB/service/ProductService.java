package com.mhallman.EJB.service;

import java.util.List;

import com.mhallman.EJB.domain.Product;

public interface ProductService {

	void addProduct(Product product);
	void deleteProduct(Product product);
	void updateProduct(Product product, String productName, String brandName, Double price, Boolean isAvailable);
	List<Product> getAllProducts();
	Product getProductById(Integer id);
	List<Product> getAvailableProducts();
	
}
