package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Customer;

public class CustomerRepo extends JPADao<Customer> implements JPARepo<Customer>
{
	
	@Override
	public Customer create(Customer entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public Customer update(Customer entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	
	@Override
	public Customer get(Customer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Customer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
