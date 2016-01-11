package com.mhallman.EJB.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@SuppressWarnings("serial")
@Entity
@Table(name="PRODUCT")
@NamedQueries({
	@NamedQuery(name = "getAllProducts", query = "Select p from PRODUCT p"),
	@NamedQuery(name = "getProductByBrandName", query = "Select p from PRODUCT p Where p.BRAND_NAME=?"),
	@NamedQuery(name = "getAvailableProducts", query = "Select p from PRODUCT p Where p.AVAILABLE=true"),
})
public class Product{

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="BRAND_NAME")
	private String brandName;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="AVAILABLE")
	private boolean available;

	
	
	public Product(){
		
	}
	
	public Product(String productName, String brandName, Double price){
		super();
		this.productName=productName;
		this.brandName=brandName;
		this.price=price;
		this.available=true;
	}
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the productName
	 */
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
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	
}	
