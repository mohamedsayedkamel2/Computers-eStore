package com.computer.store.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Review;

public class ReviewRepo extends JPADao<Review> implements JPARepo<Review>{
	
	@Override
	public Review create(Review entity) {
		return super.create(entity);
	}

	@Override
	public Review update(Review entity) {
		return super.update(entity);
	}
	
	@Override
	public Review get(Object id) {
		return super.find(Review.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Review.class, id);
	}

	@Override
	public List<Review> listAll() {
		return super.findWithNameQuery("Review.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Review.countAll");
	}
	
	public Review findByCustomerAndProduct(Long long1, Long productId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("customerId", long1);
		parameters.put("prodId", productId);
		
		List<Review> result = super.findWithNameQuery("Review.findByCustomerAndProduct", parameters);
		
		if(!result.isEmpty()) {
			return result.get(0);
		}
		
		return null;
	}
}
