package com.computer.store.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.service.impl.user.UserLoginService;


@WebServlet("/admin/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8335563291665687201L;
	
	public LoginServlet()
	{
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin/login.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserRepo userRepo = new UserRepo();
		UserLoginService loginService = new UserLoginService(request, response, userRepo);
		loginService.login();
	}

}
