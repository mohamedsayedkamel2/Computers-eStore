package com.computer.store.admin.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.DeletionService;
import com.computer.store.service.impl.customer.CustomerDeletionService;


@WebServlet("/admin/delete_customer")
public class CustomerDelete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public CustomerDelete() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeletionService deletionService = new CustomerDeletionService(request, response, new CustomerRepo());
		deletionService.delete();
	}
}
