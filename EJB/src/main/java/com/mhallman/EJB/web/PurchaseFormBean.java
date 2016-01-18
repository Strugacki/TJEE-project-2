package com.mhallman.EJB.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;
import com.mhallman.EJB.service.SellProductService;


@SessionScoped
@Named("purchaseBean")
public class PurchaseFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellProductService ss;

	public String sellProduct(Client client, Product product) {
		ss.sellProduct(client, product);;
		return null;
	}
}
