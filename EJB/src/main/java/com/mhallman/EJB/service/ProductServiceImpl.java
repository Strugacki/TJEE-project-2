package com.mhallman.EJB.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhallman.EJB.domain.Client;
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
	
	/*****************************************************************************************************************************************************/
	public void sellProduct(long clientId, long productId) {
		
		Client client = em.find(Client.class, clientId);
		Product product = em.find(Product.class, productId);
		product.setAvailable(false);
		client.getProducts().add(product);
		
	}

	public void disposeProduct(Client client, Product product) {

		product = em.find(Product.class, product.getId());
		client = em.find(Client.class, client.getId());

		Product toRemove = null;
		// lazy loading here (person.getCars)
		for (Product productt : client.getProducts())
			if (productt.getId().compareTo(product.getId()) == 0) {
				toRemove = productt;
				break;
			}

		if (toRemove != null)
			client.getProducts().remove(toRemove);
		
		product.setAvailable(false);
	}
		

	public void complaintProduct(Client client, Product product) {
		
		client = em.find(Client.class, client.getId());
		product = em.find(Product.class, product.getId());
		product.setAvailable(true);
		for(Product productt : client.getProducts()){
			if(productt.getId().compareTo(product.getId()) == 0 ){
				client.getProducts().remove(productt);
				productt.setAvailable(true);
				break;
			}
		}
	}
	
}
