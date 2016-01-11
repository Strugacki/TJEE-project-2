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
	
	
	@Override
	public void addClient(Client client) {
		em.persist(client);
	}

	@Override
	public void deleteClient(Client client) {
		client = em.find(Client.class, client.getId());
		em.remove(client);
	}

	@Override
	public void updateClient(Client client) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		return em.createNamedQuery("getAllClients").getResultList();
	}

	@Override
	public Client getClientById(Integer id) {
		
		return null;
	}

	@Override
	public Client getClientByPhone(String phone) {
		
		return null;
	}

	@Override
	public List<Product> getBoughtProducts(Client client) {
		client = em.find(Client.class, client.getId());
		List<Product> products = new ArrayList<Product>(client.getProducts());
		return null;
	}

}
