package com.computer.store.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.ProductService;

@WebServlet("/motherboard")
public class MotherboardList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MotherboardList() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("category", "Motherboard");
		ProductService productService = new ProductService(request, response);
		productService.getListByCategory(3L);
	}
}
