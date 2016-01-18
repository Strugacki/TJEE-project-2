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
	
	
	public void addProduct(Product product){
		em.persist(product);
	}
	
	public void deleteProduct(Product product){
		product = em.find(Product.class, product.getId());
		em.remove(product);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts(){
		return em.createNamedQuery("getAllProducts").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getAvailableProducts(){
		return em.createNamedQuery("getAvailableProducts").getResultList();
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
