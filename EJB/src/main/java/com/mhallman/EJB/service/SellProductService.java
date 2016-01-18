package com.mhallman.EJB.service;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;

public interface SellProductService {

	void sellProduct(Client client, Product product);
	void disposeProduct(Client client, Product product);
	void complaintProduct(Client client, Product product);
}
