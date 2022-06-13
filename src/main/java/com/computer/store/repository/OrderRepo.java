package com.computer.store.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Order;

public class OrderRepo extends JPADao<Order> implements JPARepo<Order> {

	@Override
	public Order create(Order entity) {
		return super.create(entity);
	}

	@Override
	public Order update(Order entity) {
		return super.update(entity);
	}
	
	public Order get(Integer orderId, Integer customerId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("orderId", orderId);
		parameters.put("customerId", customerId);
		
		List<Order> result = super.findWithNameQuery("Order.findByIdAndCustomer", parameters);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}
	
	
	@Override
	public Order get(Object id) {
		return super.find(Order.class, id);
	}
	
	@Override
	public void delete(Object id) {
		super.delete(Order.class, id);
	}

	@Override
	public List<Order> listAll() {
		return super.findWithNameQuery("Order.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Order.countAll");
	}
	
	public List<Order> listByCustomer(Integer customerId) {
		
		return super.findWithNameQuery("BookOrder.findByCustomer", "customerId", customerId);
	}
}
