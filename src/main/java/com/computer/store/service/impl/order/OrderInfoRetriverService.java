package com.computer.store.service.impl.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.entites.Order;
import com.computer.store.service.InfoReterivingService;

public class OrderInfoRetriverService implements InfoReterivingService
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private OrderRepo orderRepo;
	
	public OrderInfoRetriverService(HttpServletRequest request, HttpServletResponse response, OrderRepo orderRepo) {
		this.request = request;
		this.response = response;
		this.orderRepo = orderRepo;
	}
	
	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		List<Order> listOrder = orderRepo.listAll();
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		request.setAttribute("orders", listOrder);
		String listPage = "/jsp/admin/order/order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
}