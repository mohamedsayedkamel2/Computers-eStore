package com.computer.store.admin.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		// The argument is set to false to prevent a new session from being created
		HttpSession session = httpServletRequest.getSession(false);
		
		// Checks if the user is loggined or not
		boolean loggedIn = session != null && session.getAttribute("user_email") != null;
		String loginUri = httpServletRequest.getContextPath() + "/admin/login";
		boolean loginRequest = httpServletRequest.getRequestURI().equals(loginUri);
		boolean loginPage = httpServletRequest.getRequestURI().endsWith("login.jsp");
		
		// Checks if the admin user is already authenticated if true the redirect the request to another URI
		if (loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/create_category");
			requestDispatcher.forward(request, response);
		}
		// Checks if the user is authenticated if true then the user is allowed to view the website
		else if (loggedIn || loginRequest) {
			chain.doFilter(request, response);
		}
		// This code will execute to prevent the unauthenticated request from viewing the admin website
		else {
			RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/jsp/admin/login.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void destroy() {
		
	}

}
