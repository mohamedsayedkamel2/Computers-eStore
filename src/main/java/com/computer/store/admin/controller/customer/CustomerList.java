package com.computer.store.admin.controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.impl.customer.CustomerInfoRetriverService;

@WebServlet("/admin/list_customers")
public class CustomerList extends HttpServlet {
	
    private static final long serialVersionUID = 791298222587716678L;
	private static CustomerRepo customerRepo;
    
	public CustomerList() {
		customerRepo = new CustomerRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoReterivingService infoService = new CustomerInfoRetriverService(request, response, customerRepo);
		infoService.retriveInfo(null);
	}
}