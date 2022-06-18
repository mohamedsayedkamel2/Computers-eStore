package com.computer.store.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.UserRepo;
import com.computer.store.repository.entites.User;

public class UserService {
	UserRepo userRepo;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserService() {
		
	}
	
	public UserService(HttpServletRequest request, HttpServletResponse response){
		userRepo = new UserRepo();
		this.request = request;
		this.response = response;
	}
	
	public void listUser(String message) throws ServletException, IOException {
		 List<User> listUsers = userRepo.listAll();
		 request.setAttribute("users", listUsers);
		 request.setAttribute("message", message);
		 String listPage = "/jsp/admin/user/user_list.jsp";
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		 requestDispatcher.forward(request, response);
	}
	
	public void listUser() throws ServletException, IOException {
		listUser(null);
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

	public void editUser() throws ServletException, IOException {
		Long userId = Long.parseLong(request.getParameter("id"));
		User user = userRepo.get(userId);
		String editPage = "/jsp/admin/user/edit_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}
	
	public void updateUser() throws ServletException, IOException {
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
			listUser(message);
		}
}

	public void deleteUser() throws ServletException, IOException {
		Long userId =Long.parseLong(request.getParameter("id"));
		userRepo.delete(userId);
		String message = "User has been deleted successfully";
		listUser(message);
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