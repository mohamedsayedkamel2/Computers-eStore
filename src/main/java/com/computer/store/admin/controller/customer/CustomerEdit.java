package com.computer.store.admin.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.customer.CustomerUpdateAdminService;
import com.computer.store.util.CustomerUpdateUtil;

@WebServlet("/admin/edit_customer")
public class CustomerEdit extends HttpServlet {
       
    private static final long serialVersionUID = -5420125129540530396L;
    private static CustomerRepo customerRepo;
    
	public CustomerEdit() {
		@SuppressWarnings("unused")
		CustomerRepo customerRepo = new CustomerRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new CustomerUpdateAdminService(request, response, customerRepo, new CustomerUpdateUtil(request));
		service.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new CustomerUpdateAdminService(request, response, customerRepo, new CustomerUpdateUtil(request));
		service.update();
	}
}