package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Product;

public class ProductRepo extends JPADao<Product> implements JPARepo<Product> {
	
	@Override
	public Product create(Product entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public Product update(Product entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	@Override
	public Product get(Product id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Product id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
