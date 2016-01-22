package com.mhallman.EJB.service;

import java.util.List;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;

public interface ProductService {

	void addProduct(Product product);
	void deleteProduct(Product product);
	void updateProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);
	List<Product> getAvailableProducts();
	
	void sellProduct(long clientId, long productId);
	void disposeProduct(Client client, Product product);
	void complaintProduct(Client client, Product product);
	
}
