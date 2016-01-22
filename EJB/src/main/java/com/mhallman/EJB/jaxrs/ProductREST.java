package com.mhallman.EJB.jaxrs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mhallman.EJB.domain.Product;
import com.mhallman.EJB.service.ClientService;
import com.mhallman.EJB.service.ProductService;

@Stateless
@Path("/productr")
public class ProductREST {

	
	@EJB
	private ClientService cs;
	
	@EJB
	private ProductService ps;
	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll(){
		
		return ps.getAllProducts();
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Product add(
			@FormParam("productName") String productName,
			@FormParam("brandName") String brandName,
			@FormParam("price") Double price
	){
		
		Product product = new Product();
		product.setProductName(productName);
		product.setBrandName(brandName);
		product.setPrice(price);
		
		ps.addProduct(product);
		
		return product;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(
			@PathParam("id") long id
	){
		
		ps.deleteProduct(ps.getProductById(id));
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product update(
			@PathParam("id") long id,
			@FormParam("productName") String productName,
			@FormParam("brandName") String brandName,
			@FormParam("price") double price,
			@FormParam("available") boolean available
	){
		Product product = ps.getProductById(id);
		product.setProductName(productName);
		product.setBrandName(brandName);
		product.setPrice(price);
		product.setAvailable(available);
		ps.updateProduct(product);
		
		return product;
		
	}
	
	
}
