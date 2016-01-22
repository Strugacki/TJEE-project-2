package com.mhallman.EJB.jaxrs;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mhallman.EJB.domain.Client;
import com.mhallman.EJB.service.ClientService;

@Stateless
@Path("/clientr")
public class ClientREST {
	
	@EJB
	private ClientService cs;

	
	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> getAll(){
		return cs.getAllClients();
	}
	
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Client add(
		@FormParam("firstName") String firstName,
		@FormParam("lastName") String lastName,
		@FormParam("phoneNumber") String phoneNumber
	){
			Client client = new Client();
			
			client.setFirstName(firstName);
			client.setLastName(lastName);
			client.setPhoneNumber(phoneNumber);
			
			cs.addClient(client);
			
			return client;
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(
			@PathParam("id") long id
	){
		cs.deleteClient(cs.getClientById(id));
	}
	
	@GET
	@Path("/show/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Client show(
			@PathParam("id") long id
	){
		return cs.getClientById(id);
	}
	
	
	
}
