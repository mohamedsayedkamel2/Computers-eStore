package com.computer.store.service.impl.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;

public class UserLoginService 
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final UserRepo userRepo;
	
	public UserLoginService(HttpServletRequest request, HttpServletResponse response,UserRepo userRepo)
	{
		this.request = request;
		this.response = response;
		this.userRepo = userRepo;
	}
	
	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean loginResult = userRepo.checkLogin(email, password);
		
		if (loginResult) {
			System.out.println("User is authenticated");
			request.getSession().setAttribute("user_email", email);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Computers4Sale/");
			requestDispatcher.forward(request, response);
			}
		else {
			String message = "Login failed!";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
