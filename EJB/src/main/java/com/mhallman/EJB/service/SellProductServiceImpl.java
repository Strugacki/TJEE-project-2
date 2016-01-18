package com.mhallman.EJB.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;

@Stateless
public class SellProductServiceImpl implements SellProductService {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void sellProduct(Client client, Product product) {
		
		client = em.find(Client.class, client.getId());
		product = em.find(Product.class, product.getId());
		product.setAvailable(false);
		client.getProducts().add(product);
		
	}

	@Override
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
		

	@Override
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
