package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.DeletionService;

public class CustomerDeletionService implements DeletionService
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	
	public CustomerDeletionService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
	}
	
	public void delete() throws ServletException, IOException 
	{
		Long customerId = Long.parseLong(request.getParameter("id"));
		customerRepo.delete(customerId);
		
		String message = "The customer has been deleted.";
		new CustomerInfoRetriverService(request, response, customerRepo).retriveInfo(message);
	}
}
