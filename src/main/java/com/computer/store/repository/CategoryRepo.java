package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Category;

public class CategoryRepo extends JPADao<Category> implements JPARepo<Category>
{

	@Override
	public Category create(Category entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}
	
	@Override
	public Category update(Category entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	@Override
	public Category get(Category id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Category id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
