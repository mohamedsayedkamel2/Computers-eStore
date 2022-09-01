package com.computer.store.service.impl.payment;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Order;
import com.computer.store.repository.entites.Product;
import com.computer.store.service.impl.order.OrderCreationService;

public class PaymentService {
	HttpServletRequest request;
	HttpServletResponse response;
	OrderCreationService orderCreationService;
	OrderRepo orderRepo;
	ProductRepo productRepo;
	
	public PaymentService(HttpServletRequest request, HttpServletResponse response,
			OrderCreationService orderCreationService, OrderRepo orderRepo, ProductRepo productRepo)
	{
		this.request = request;
		this.response = response;
		this.orderCreationService = orderCreationService;
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
	}
	
	public void buyProduct() throws IOException {
		// Get the product ID from the params
		Long productId = Long.parseLong(request.getParameter("id"));
		// Create a product repo object and get the product object by ID
		ProductRepo productRepo = new ProductRepo();
		Product product = productRepo.get(productId);
		// Get the logged customer
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		// Save the order in the DB
		Order order = orderCreationService.createOrder(product, customer);
		// Get the customer orders and add the new order to them
		List<Order> customerOrders = customer.getCustomerOrders();
		customerOrders.add(order);
		new CustomerRepo().update(customer);
		redirectRequest();
	}
	
	void redirectRequest() throws IOException {
		request.setAttribute("message", "You have bought a product successfuly! Check your email inbox");
		response.sendRedirect("/Computers4Sale/customer_products");
	}
}
