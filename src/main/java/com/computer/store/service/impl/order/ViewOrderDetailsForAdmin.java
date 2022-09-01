package com.computer.store.service.impl.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.entites.Order;

public class ViewOrderDetailsForAdmin {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderRepo orderRepo;
	
	public ViewOrderDetailsForAdmin(HttpServletRequest request, HttpServletResponse response, OrderRepo orderRepo) {
		this.request = request;
		this.response = response;
		this.orderRepo = orderRepo;
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
