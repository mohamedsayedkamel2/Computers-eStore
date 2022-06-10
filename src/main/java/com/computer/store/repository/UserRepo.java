package com.computer.store.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public User get(Object user) {
		return super.find(User.class, user);
	}

	@Override
	public void delete(Object user) {
		super.delete(User.class, user);
	}

	@Override
	public List<User> listAll() {
		return super.findWithNameQuery("User.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("User.countAll");
	}
	
	public User findByEmail(String email) {
		List<User>userList =  super.findWithNameQuery("User.findByEmail", "email", email);
		if (userList != null && userList.size() == 1) {
			return userList.get(0);
		}
		return null;
	}
	
	public boolean checkLogin(String email, String password) {
		Map<String, Object> param = new HashMap<>();
		param.put("email", email);
		param.put("password", password);
		List<User> list = super.findWithNameQuery("User.checkLogin", param);
		if (list.size() == 1)
		{
			return true;
		}
		return false;
	}
}
