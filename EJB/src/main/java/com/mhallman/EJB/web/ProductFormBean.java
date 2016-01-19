package com.mhallman.EJB.web;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.domain.Product;
import com.mhallman.EJB.service.ClientService;
import com.mhallman.EJB.service.ProductService;
import com.mhallman.EJB.service.SellProductService;

@SessionScoped
@Named("productBean")
public class ProductFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Product product = new Product();
	private ListDataModel<Product> products = new ListDataModel<Product>();
	private Product productToShow = new Product();
	
	private ListDataModel<Product> soldProducts = new ListDataModel<Product>();
	
	@Inject 
	private ClientService cs;
	
	@Inject
	private ProductService ps;
	
	
	private long clientId;
	private long productId;
	/**
	 * @return the clientId
	 */
	public long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	public List<Client> getAllClients(){
		return cs.getAllClients();
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
	
	/**
	 * 
	 * @return
	 */
	public String showDetails() {
		productToShow = products.getRowData();
		return "details";
	}
	
	public String prepareUpdate(){
		product = products.getRowData();
		ps.updateProduct(product);
		return "prepareUpdate";
	}
	
	public String updateProduct() {
		ps.updateProduct(product);
		return "showTerminals";
	}
	
	public String sellProduct(){
		ps.sellProduct(clientId, productId);
		return null;
	}
	
	public List<Product> getAvailableProducts(){
		return ps.getAvailableProducts();
	}
	
	
}