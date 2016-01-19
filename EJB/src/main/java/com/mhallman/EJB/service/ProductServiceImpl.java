package com.mhallman.EJB.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhallman.EJB.domain.Product;

@Stateless
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Add product method
	 */
	public void addProduct(Product product){
		product.setId(null);
		em.persist(product);
	}
	
	/**
	 * Delete product method
	 */
	public void deleteProduct(Product product){
		product = em.find(Product.class, product.getId());
		em.remove(product);
	}
	
	/**
	 * Get product method
	 * returns List<Product>
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		return em.createNamedQuery("product.all").getResultList();
	}
	
	/**
	 * Get available product method
	 * returns List<Product> with available products
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getAvailableProducts(){
		return em.createNamedQuery("product.available").getResultList();
	}

	/**
	 * Update product method
	 * params @product
	 */
	public void updateProduct(Product product) {
		em.merge(product);
		
	}

	/**
	 * returns product with @id 
	 */
	public Product getProductById(Integer id) {
		return em.find(Product.class, id);
	}
	
}
