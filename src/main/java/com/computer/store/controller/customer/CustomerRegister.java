package com.computer.store.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.impl.customer.CustomerRegistrationService;
import com.computer.store.util.CustomerUpdateUtil;

@WebServlet("/register")
public class CustomerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerRegister() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerRegistrationService service = new CustomerRegistrationService(request, response, new CustomerRepo(), new CustomerUpdateUtil(request));
		service.ShowCustomerRegisterForm();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerRegistrationService service = new CustomerRegistrationService(request, response, new CustomerRepo(), new CustomerUpdateUtil(request));
		service.registerCustomer();
	}
}