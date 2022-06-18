package com.computer.store.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.entites.Order;

public class OrderService {
	
	private OrderRepo orderRepo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public OrderService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.orderRepo = new OrderRepo();
	}
	
	public void listAllOrder() throws ServletException, IOException {
		listAllOrder(null);
	}

	public void listAllOrder(String message) throws ServletException, IOException {
		List<Order> listOrder = orderRepo.listAll();
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("orders", listOrder);
		String listPage = "/jsp/admin/order/order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		Long orderId = Long.parseLong(request.getParameter("id"));
		
		Order order = orderRepo.get(orderId);
		request.setAttribute("order", order);
		
		String detailPage = "/jsp/admin/order/order_detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
		
	}
	
}