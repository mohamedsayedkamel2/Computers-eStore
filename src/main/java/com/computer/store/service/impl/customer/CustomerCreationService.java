package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.util.CustomerUpdateUtil;

public class CustomerCreationService 
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	private CustomerUpdateUtil customerUtil;
	
	public CustomerCreationService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo, CustomerUpdateUtil customerUtil) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
		this.customerUtil = customerUtil;
	}
	
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerRepo.findByEmail(email);
		
		if (existCustomer != null) {
			String message = "Could not create new customer: the email "
					+ email + " is already registered by another customer";
			new CustomerInfoRetriverService(request, response, customerRepo).retriveInfo(message);
		}
		else {
			Customer newCustomer = new Customer();
			customerUtil.updateCustomerFieldsFromForm(newCustomer);
			customerRepo.create(newCustomer);
			
			String message = "New customer has been created successfully";
			new CustomerInfoRetriverService(request, response, customerRepo).retriveInfo(message);
		}
	}
}
