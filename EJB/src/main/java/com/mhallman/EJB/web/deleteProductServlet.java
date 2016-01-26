package com.mhallman.EJB.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhallman.EJB.service.ProductService;

@WebServlet(urlPatterns = "deleteProduct/*")
public class deleteProductServlet {
	
	@EJB
	private ProductService ps;
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String link = request.getPathInfo();
		     ps.deleteProduct(ps.getProductById(Long.parseLong(link.substring(link.lastIndexOf("/") + 1, link.length()))));
		 	 response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Product"));
	 }

}
