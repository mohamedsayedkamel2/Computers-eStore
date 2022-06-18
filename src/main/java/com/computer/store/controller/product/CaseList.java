package com.computer.store.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.ProductService;

@WebServlet("/case")
public class CaseList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CaseList() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("category", "Case");
		ProductService productService = new ProductService(request, response);
		productService.getListByCategory(4L);
	}
}
