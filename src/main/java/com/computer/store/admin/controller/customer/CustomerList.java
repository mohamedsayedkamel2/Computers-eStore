package com.computer.store.admin.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.CustomerService;

@WebServlet("/admin/list_customers")
public class CustomerList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CustomerList() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerService customerService = new CustomerService(request, response);
		customerService.listCustomer();
	}

}
