package com.mhallman.EJB.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@NamedQueries({
	@NamedQuery(name = "product.all", query = "Select p from Product p"),
	@NamedQuery(name = "product.available", query = "Select pp from Product pp where pp.available = true"),
})
public class Product{

	private Long id;
	
	private String productName;
	
	private String brandName;
	
	private double price;
	
	private Boolean available = true;

	
	
	public Product(){
		
	}
	
	public Product(String productName, String brandName, Double price, Boolean available){
		super();
		this.productName=productName;
		this.brandName=brandName;
		this.price=price;
		this.available=available;
	}
	
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the productName
	 */
	@Size(min=2, max=50)
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the brandName
	 */
	@Size(min=2, max=20)
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * @return the price
	 */
	@Max(10000)
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * @return the available
	 */
	public boolean getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	
}	
