package com.computer.store.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Order;

@WebServlet("/customer_products")
public class CustomerProducts extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CustomerProducts() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		List<Order>customerOrders = customer.getCustomerOrders();
		request.setAttribute("orders", customerOrders);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/customer/customer_orders.jsp");
		dispatcher.forward(request, response);
	}
}
