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
@Named("productBean")
public class ProductFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Product product = new Product();
	private ListDataModel<Product> products = new ListDataModel<Product>();
	private Product productToShow = new Product();
	
	private ListDataModel<Product> soldProducts = new ListDataModel<Product>();
	
	@Inject
	private ProductService ps;
	
	/**
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 
	 * @param client
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
	/**
	 * 
	 * @return
	 */
	public ListDataModel<Product> getAllProducts() {
		products.setWrappedData(ps.getAllProducts());
		return products;
	}
	

	/**
	 * 
	 * @return
	 */
	public String addProduct() {
		ps.addProduct(product);;
		return "products";
	}
	
	/**
	 * 
	 * @return
	 */
	public String deleteProduct() {
		Product productToDelete = products.getRowData();
		ps.deleteProduct(productToDelete);
		return null;
	}
	
}