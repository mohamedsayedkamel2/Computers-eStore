package com.computer.store.service.impl.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.repository.entites.User;
import com.computer.store.service.InfoReterivingService;

public class UserInfoRetriverService implements InfoReterivingService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final UserRepo userRepo;
	
	public UserInfoRetriverService(HttpServletRequest request, HttpServletResponse response,UserRepo userRepo)
	{
		this.request = request;
		this.response = response;
		this.userRepo = userRepo;
	}

	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		 List<User> listUsers = userRepo.listAll();
		 request.setAttribute("users", listUsers);
		 request.setAttribute("message", message);
		 String listPage = "/jsp/admin/user/user_list.jsp";
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		 requestDispatcher.forward(request, response);
	}
}
