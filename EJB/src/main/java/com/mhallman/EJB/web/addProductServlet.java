package com.mhallman.EJB.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mhallman.EJB.service.ProductService;


@WebServlet(urlPatterns = "/addProduct")
public class addProductServlet extends HttpServlet{
    @EJB
    private ProductService ps;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/Product/addProduct.jsp").forward(request, response);
    }
}
