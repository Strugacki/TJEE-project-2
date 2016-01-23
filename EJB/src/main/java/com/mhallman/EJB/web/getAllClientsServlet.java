package com.mhallman.EJB.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhallman.EJB.service.ClientService;


@WebServlet(urlPatterns = "/Client")
public class getAllClientsServlet extends HttpServlet{

	@EJB
    private ClientService cs;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/Client/showClients.jsp").forward(request, response);
    }
	
}
