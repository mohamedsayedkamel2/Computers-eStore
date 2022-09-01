package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.service.UpdatingService;
import com.computer.store.util.CustomerProfileUtil;
import com.computer.store.util.CustomerUpdateUtil;

public class CustomerUpdateService implements UpdatingService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	private CustomerUpdateUtil customerUtil;
	
	public CustomerUpdateService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo, CustomerUpdateUtil customerUtil) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
		this.customerUtil = customerUtil;
	}

	@Override
	public void getUserPage() throws ServletException, IOException {
		String editPage = "/jsp/customer/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		customerUtil.updateCustomerFieldsFromForm(customer);
		customerRepo.update(customer);
		request.setAttribute("message", "Your profile has been updated !");
		new CustomerProfileUtil(request, response).showCustomerProfile();
	}
	

}