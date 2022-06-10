package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Order;

public class OrderRepo extends JPADao<Order> implements JPARepo<Order> {

	@Override
	public Order create(Order entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public Order update(Order entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	@Override
	public Order get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
