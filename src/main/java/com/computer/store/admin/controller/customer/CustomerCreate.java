package com.computer.store.admin.controller.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.customer.CustomerUpdateAdminService;
import com.computer.store.util.CustomerUpdateUtil;

@WebServlet("/admin/create_customer")
public class CustomerCreate extends HttpServlet {
       
    private static final long serialVersionUID = 4984164095426721149L;
    private static CustomerRepo repo;
    
	public CustomerCreate() {
		CustomerRepo repo = new CustomerRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin/customer/customer_form.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService updatingService = new CustomerUpdateAdminService(request, response, repo, new CustomerUpdateUtil(request));
		updatingService.update();
	}
}
