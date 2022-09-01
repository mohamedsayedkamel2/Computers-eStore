package com.computer.store.service.impl.order;

import java.time.LocalDate;

import com.computer.store.repository.OrderRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Order;
import com.computer.store.repository.entites.Product;

public class OrderCreationService {
	
	private OrderRepo orderRepo;
	
	public OrderCreationService(OrderRepo orderRepo)
	{
		this.orderRepo = orderRepo;
	}
	
	public Order createOrder(Product product, Customer customer) {
		Order order = new Order();
		order.setProduct(product);
		order.setCustomer(customer);
		order.setProduct(product);
		order.setQuantity(1);
		order.setSubTotal(product.getPrice());
		order.setOrderDate(LocalDate.now());
		return orderRepo.create(order);
	}
}
