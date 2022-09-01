package com.computer.store.service.impl.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.service.UpdatingService;
import com.computer.store.util.CustomerUpdateUtil;

public class CustomerUpdateAdminService implements UpdatingService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	private CustomerUpdateUtil customerUtil;
	
	public CustomerUpdateAdminService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo, CustomerUpdateUtil customerUtil) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
		this.customerUtil = customerUtil;
	}

	@Override
	public void getUserPage() throws ServletException, IOException {
		List<Customer> customersList = customerRepo.listAll();
		request.setAttribute("customers", customersList);
		
		String listPage = "/jsp/admin/customer/list_customer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Long customerId = Long.parseLong(request.getParameter("id"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerRepo.findByEmail(email);
		String message = null;
		
		if (customerByEmail != null && customerByEmail.getId() != customerId) {
		    message = "Could not update the customer ID " + customerId 
					+ " because there's an existing customer having the same email.";
		}else {
			
			Customer customerById = customerRepo.get(customerId);
			customerUtil.updateCustomerFieldsFromForm(customerById);
			customerRepo.update(customerById);
			
			message = "The customer is successfully updated.";
		}
		listCustomer(message);
	}
	
	public void listCustomer(String message) throws ServletException, IOException {
		List<Customer> customersList = customerRepo.listAll();
		request.setAttribute("customers", customersList);
		request.setAttribute("message", message);
		
		String listPage = "/jsp/admin/customer/list_customer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
}
