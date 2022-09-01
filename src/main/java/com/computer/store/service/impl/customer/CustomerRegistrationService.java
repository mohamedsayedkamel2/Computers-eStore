package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.util.CustomerUpdateUtil;

public class CustomerRegistrationService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	private CustomerUpdateUtil customerUtil;
	
	public CustomerRegistrationService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo, CustomerUpdateUtil customerUtil) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
		this.customerUtil = customerUtil;
	}
	
	public void ShowCustomerRegisterForm() throws ServletException, IOException {
		String registerForm = "/jsp/customer/register_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
		dispatcher.forward(request, response);
	}
	
	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerRepo.findByEmail(email);
		String message = "";
		
		if (existCustomer != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another customer";
		}
		else {
			Customer newCustomer = new Customer();
			customerUtil.updateCustomerFieldsFromForm(newCustomer);
			
			customerRepo.create(newCustomer);
			
			message = "You have been created successfully, thank you!<br/>"
					+ "<a href='/Computers4Sale/login'>Click here</a> to login";
		}
		
		String messagePage = "/jsp/common/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		requestDispatcher.forward(request, response);
	}
}
