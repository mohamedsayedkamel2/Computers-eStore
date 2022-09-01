package com.computer.store.service.impl.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.repository.entites.User;
import com.computer.store.service.UpdatingService;

public class UserUpdatingService implements UpdatingService
{
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final UserRepo userRepo;
	
	public UserUpdatingService(HttpServletRequest request, HttpServletResponse response,UserRepo userRepo)
	{
		this.request = request;
		this.response = response;
		this.userRepo = userRepo;
	}

	@Override
	public void getUserPage() throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("id"));
		User user = userRepo.get(userId);
		String editPage = "/jsp/admin/user/edit_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Long userId =Long.parseLong(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(userId + " " + email + " " + fullName + " " + password + " ");
		User getUserById = userRepo.get(userId);
		User userByEmail = userRepo.findByEmail(email);
		if(userByEmail != null && userByEmail.getId() != getUserById.getId()) {
			String message = "Could not update user. User with email" + email + "already exists.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/common/message.jsp");
			requestDispatcher.forward(request, response);
	}
		else {
			User user = new User();
			user.setId(userId);
			user.setFullName(fullName);
			user.setEmail(email);
			user.setPassword(password);
			userRepo.update(user);
			String message = "User has been updated successfully";
			new UserInfoRetriverService(request, response, userRepo).retriveInfo(message);
		}
	}
}
