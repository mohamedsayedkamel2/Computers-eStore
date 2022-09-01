package com.computer.store.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerProfileUtil {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerProfileUtil(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "/jsp/customer/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}
	
}
