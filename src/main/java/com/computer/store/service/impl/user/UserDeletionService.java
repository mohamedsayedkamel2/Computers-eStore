package com.computer.store.service.impl.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.service.DeletionService;

public class UserDeletionService implements DeletionService
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final UserRepo userRepo;
	
	public UserDeletionService(HttpServletRequest request, HttpServletResponse response,UserRepo userRepo)
	{
		this.request = request;
		this.response = response;
		this.userRepo = userRepo;
	}

	@Override
	public void delete() throws ServletException, IOException {
		Long userId =Long.parseLong(request.getParameter("id"));
		userRepo.delete(userId);
		String message = "User has been deleted successfully";
		new UserInfoRetriverService(request, response, userRepo).retriveInfo(message);
	}
}
