package com.computer.store.repository;

import java.util.List;

import com.computer.store.config.repo.JPADao;
import com.computer.store.config.repo.JPARepo;
import com.computer.store.repository.entites.User;

public class UserRepo extends JPADao<User> implements JPARepo<User> {

	@Override
	public User create(User user) {
		return super.create(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return super.update(user);
	}
	
	@Override
	public User get(User user) {
		return super.find(User.class, user);
	}

	@Override
	public void delete(User user) {
		super.delete(User.class, user);
	}

	@Override
	public List<User> listAll() {
		return super.findWithNameQuery("Users.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Users.countAll");
	}
}
