package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Category;

public class CategoryRepo extends JPADao<Category> implements JPARepo<Category>
{

	public CategoryRepo() {
	}
	
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
	public Category get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNameQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}
	
	public Category findByName(String categoryName) {
		List<Category> result = super.findWithNameQuery("Category.findByName", "name", categoryName);
		
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		
		return null;
	}
}