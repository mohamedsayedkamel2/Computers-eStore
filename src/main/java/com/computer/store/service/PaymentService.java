package com.computer.store.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Order;
import com.computer.store.repository.entites.Product;

public class PaymentService {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public PaymentService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void buyProduct() throws IOException {
		// Get the product ID from the params
		Long productId = Long.parseLong(request.getParameter("id"));
		// Create a product repo object and get the product object by ID
		ProductRepo productRepo = new ProductRepo();
		Product product = productRepo.get(productId);
		// Get the logged customer
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		OrderRepo orderRepo = new OrderRepo();
		// Save the order in the DB
		Order order = createOrder(product, customer);
		orderRepo.create(order);
		// Get the customer orders and add the new order to them
		List<Order> customerOrders = customer.getCustomerOrders();
		customerOrders.add(order);
		new CustomerRepo().update(customer);
		redirectRequest();
	}
	
	Order createOrder(Product product, Customer customer) {
		Order order = new Order();
		order.setProduct(product);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setQuantity(1);
		order.setSubTotal(product.getPrice());
		order.setOrderDate(LocalDate.now());
		return order;
	}
	
	void redirectRequest() throws IOException {
		request.setAttribute("message", "You have bought a product successfuly! Check your email inbox");
		response.sendRedirect("/Computers4Sale/customer_products");
	}
}
