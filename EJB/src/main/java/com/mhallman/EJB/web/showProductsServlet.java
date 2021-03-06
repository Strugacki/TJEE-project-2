package com.mhallman.EJB.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhallman.EJB.service.ProductService;

@WebServlet(urlPatterns = "/showProducts")
public class showProductsServlet {

	@EJB
	private ProductService ps;
	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("views/Product/showProducts.jsp").forward(request, response);
	    }
	
}
