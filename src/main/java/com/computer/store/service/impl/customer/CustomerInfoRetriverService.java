package com.computer.store.service.impl.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.service.InfoReterivingService;

public class CustomerInfoRetriverService implements InfoReterivingService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	
	public CustomerInfoRetriverService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
	}

	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		List<Customer> customersList = customerRepo.listAll();
		request.setAttribute("customers", customersList);
		request.setAttribute("message", message);
		
		String listPage = "/jsp/admin/customer/list_customer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
}