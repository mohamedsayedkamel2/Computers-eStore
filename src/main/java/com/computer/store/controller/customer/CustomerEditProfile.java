package com.computer.store.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.customer.CustomerUpdateService;
import com.computer.store.util.CustomerUpdateUtil;

@WebServlet("/edit_profile")
public class CustomerEditProfile extends HttpServlet
{
    private static final long serialVersionUID = 4585743374861420893L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new CustomerUpdateService(request, response, new CustomerRepo(), new CustomerUpdateUtil(request));
		service.getUserPage();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new CustomerUpdateService(request, response, new CustomerRepo(), new CustomerUpdateUtil(request));
		service.update();
	}

}
