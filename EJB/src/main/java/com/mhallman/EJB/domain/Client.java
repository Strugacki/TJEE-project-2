package com.mhallman.EJB.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
	@NamedQuery(name = "getAllClients", query = "Select c from Client c"),
	//@NamedQuery(name = "getByPhone", query = "Select c from Client c Where c.phoneNumber=?"),
})
public class Client{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private List<Product> products = new ArrayList<Product>();

	/**
	 * Constructor for Client
	 */
	public Client(){
		
	}
	
	/**
	 * Constructor for Client with params
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Client(String firstName, String lastName, String phoneNumber){
		super();
		this.firstName=firstName;
		this.lastName=lastName;
		this.phoneNumber=phoneNumber;
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
	 * @return the firstName
	 */
	@Size(min=2, max=20)
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Size(min=2, max=20)
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	@Size(min=9,max=9)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Product> getProducts(){
		return products;
		
	}
	
	/**
	 * 
	 * @param products
	 */
	public void setProducts(List<Product> products){
		this.products=products;
	}
	
}
