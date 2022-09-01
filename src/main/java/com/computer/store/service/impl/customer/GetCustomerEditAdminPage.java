package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;

public class GetCustomerEditAdminPage {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	
	public GetCustomerEditAdminPage(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
	}
	
	public void getEditCustomerAdminPage() throws ServletException, IOException {
		Long customerId = Long.parseLong(request.getParameter("id"));
		Customer customer = customerRepo.get(customerId);
		
		request.setAttribute("customer", customer);
		
		String editPage = "/jsp/admin/customer/customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}
}
