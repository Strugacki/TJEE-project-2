package com.mhallman.EJB.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;


@Stateless
public class ClientServiceImpl implements ClientService {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Add client method
	 */
	@Override
	public void addClient(Client client) {
		em.persist(client);
	}

	/**
	 * Delete client method
	 */
	@Override
	public void deleteClient(Client client) {
		client = em.find(Client.class, client.getId());
		em.remove(client);
	}

	@Override
	public void updateClient(Client client) {
		
	}

	/**
	 * Get all client method
	 * returns List<Clients>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		return em.createNamedQuery("getAllClients").getResultList();
	}

	/**
	 * Get client method
	 * returns client with id from argument
	 */
	@Override
	public Client getClientById(Integer id) {
		return em.find(Client.class, id);
	}
	
	/**
	 * TO DO
	 */
	@Override
	public Client getClientByPhone(String phone) {
		return (Client) em.createNamedQuery("getByPhone").setParameter(0, phone).getResultList().get(0);
	}

	
	/**
	 * Get products method
	 * returns List<Products>
	 */
	@Override
	public List<Product> getBoughtProducts(Client client) {
		client = em.find(Client.class, client.getId());
		List<Product> products = new ArrayList<Product>(client.getProducts());
		return null;
	}

}
