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
	public Product get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Product.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Product.class, id);
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNameQuery("Product.findAll");
	}
	
	@Override
	public long count() {
		return super.countWithNamedQuery("Product.countAll");
	}

	public Product findByName(String name) {
		List<Product> result = super.findWithNameQuery("Product.findByName", "name", name);
		
		if (!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
	
	public List<Product> listByCategory (Long categoryId){
		return super.findWithNameQuery("Product.findByCategory", "categoryId", categoryId);
	}
	
	public List<Product> search(String keyword){
		return super.findWithNameQuery("Product.search", "keyword", keyword);
	}
	
	public long countByCategory (int categoryId) {
		return super.countWithNamedQuery("Product.countByCategory", "id", categoryId);
	}
}
