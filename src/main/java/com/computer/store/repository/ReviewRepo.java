package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.Review;

public class ReviewRepo extends JPADao<Review> implements JPARepo<Review>{
	
	@Override
	public Review create(Review entity) {
		// TODO Auto-generated method stub
		return super.create(entity);
	}

	@Override
	public Review update(Review entity) {
		// TODO Auto-generated method stub
		return super.update(entity);
	}
	
	@Override
	public Review get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
