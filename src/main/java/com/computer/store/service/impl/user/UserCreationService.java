package com.computer.store.service.impl.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.repository.entites.User;
import com.computer.store.service.CreationService;

public class UserCreationService implements CreationService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final UserRepo userRepo;
	
	public UserCreationService(HttpServletRequest request, HttpServletResponse response,UserRepo userRepo)
	{
		this.request = request;
		this.response = response;
		this.userRepo = userRepo;
	}
	
	public void createUser(String name, String email, String pasword) throws ServletException, IOException {
		User existingUser = userRepo.findByEmail(email);
		if (existingUser != null) {
			String message = "Couldn't create user with the email: " + email + " the email already exists";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/common/message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			User user = new User();
			user.setFullName(name);
			user.setEmail(email);
			user.setPassword(pasword);
			userRepo.create(user);
		}
	}

	@Override
	public void getUserPage() throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
