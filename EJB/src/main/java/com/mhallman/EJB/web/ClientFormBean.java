package com.mhallman.EJB.web;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;
import com.mhallman.EJB.service.ClientService;
import com.mhallman.EJB.service.ProductService;

@SessionScoped
@Named("clientBean")
public class ClientFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Client client = new Client();
	private ListDataModel<Client> clients = new ListDataModel<Client>();
	private Client clientToShow = new Client();
	
	private ListDataModel<Product> soldProducts = new ListDataModel<Product>();
	
	@Inject
	private ClientService cs;
	
	/**
	 * 
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * 
	 * @return
	 */
	public ListDataModel<Client> getAllClients() {
		clients.setWrappedData(cs.getAllClients());
		return clients;
	}
	
	/**
	 * 
	 * @return
	 */
	public ListDataModel<Product> getSoldProducts() {
		soldProducts.setWrappedData(cs.getBoughtProducts(client));
		return soldProducts;
	}
	
	/**
	 * 
	 * @return
	 */
	public String addClient() {
		cs.addClient(client);
		return "clients";
	}
	
	/**
	 * 
	 * @return
	 */
	public String deleteClients() {
		Client clientToDelete = clients.getRowData();
		cs.deleteClient(clientToDelete);
		return null;
	}
	
}