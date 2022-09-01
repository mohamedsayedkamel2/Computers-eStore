package com.computer.store.service.impl.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.util.CustomerProfileUtil;

public class CustomerLoginService
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerRepo customerRepo;
	
	public CustomerLoginService(HttpServletRequest request, HttpServletResponse response, CustomerRepo customerRepo) {
		this.request = request;
		this.response = response;
		this.customerRepo = customerRepo;
	}
	
	public void showLoginPage() throws ServletException, IOException {
		String loginPage = "/jsp/customer/login_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}
	
	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerRepo.checkLogin(email, password);
		
		if (customer == null) {
			String message = "Login failed. Please check your email and password";
			request.setAttribute("message", message);
			showLoginPage();
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			
			Object objRedictedURL = session.getAttribute("redirectURL");
			
			if (objRedictedURL != null) {
				String redirectURL = (String) objRedictedURL;
				session.removeAttribute(redirectURL);
				response.sendRedirect(redirectURL);
			}else {
				new CustomerProfileUtil(request, response).showCustomerProfile();
			}
		}
	}
}
