package com.mhallman.EJB.service;

import java.util.List;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;

public interface ClientService {

	void addClient(Client client);
	void deleteClient(Client client);
	//void updateClient(Client client);
	List<Client> getAllClients();
	Client getClientById(Integer id);
	List<Product> getBoughtProducts(Client client);
}
