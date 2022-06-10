package com.computer.store.admin.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.UserService;


@WebServlet("/admin/create_user")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUser() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin/user_form.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher;
		if (name.isEmpty() || email.isEmpty() || password.isEmpty())
		{
			requestDispatcher = request.getRequestDispatcher("/jsp/admin/user_form.jsp");
			requestDispatcher.forward(request, response);
		}
		UserService userService = new UserService(request, response);
		userService.createUser(name, email, password);
		userService.listUser("User created successfuly!");
	}

}
