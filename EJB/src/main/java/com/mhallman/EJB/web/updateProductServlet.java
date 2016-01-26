package com.mhallman.EJB.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhallman.EJB.service.ProductService;

@WebServlet(urlPatterns = "/updateProduct/*")
public class updateProductServlet {

	@EJB
	private ProductService ps;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String link = request.getPathInfo();
		request.setAttribute("toUpdateProduct",ps.getProductById((Long.parseLong(link.substring(link.lastIndexOf("/") + 1, link.length())))));
		request.getRequestDispatcher("views/Product/updateProduct.jsp").forward(request, response);
	}
		
}
