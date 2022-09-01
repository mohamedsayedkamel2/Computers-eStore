package com.computer.store.util;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import com.computer.store.repository.entites.Customer;

public class CustomerUpdateUtil {
	
	private HttpServletRequest request;
	public CustomerUpdateUtil(HttpServletRequest request) {
		this.request = request;
	}
	
	public void updateCustomerFieldsFromForm(Customer customer) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}

		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}
		
		customer.setName(name);
		customer.setCountry(country);
		customer.setCity(city);
		customer.setRegisterationDate(LocalDate.now());
	}
}
