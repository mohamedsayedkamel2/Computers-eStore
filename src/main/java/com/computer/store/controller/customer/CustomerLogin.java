package com.computer.store.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.impl.customer.CustomerLoginService;


@WebServlet("/login")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerLogin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerLoginService service = new CustomerLoginService(request, response, new CustomerRepo());
		service.showLoginPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerLoginService service = new CustomerLoginService(request, response, new CustomerRepo());
		service.doLogin();
	}

}
