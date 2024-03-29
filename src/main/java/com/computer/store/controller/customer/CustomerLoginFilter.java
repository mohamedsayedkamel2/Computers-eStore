package com.computer.store.controller.customer;

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

@WebFilter("/*")
public class CustomerLoginFilter implements Filter
{
	private static final String[] loginRequiredURLs = {"/profile", "/logout", "/edit_profile", "/write_review", "/cart", "/buy_product"};
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		
		if (path.startsWith("/admin/"))
		{
			chain.doFilter(request, response);
			return;
		}
		
		boolean loggedIn = session != null && session.getAttribute("loggedCustomer") != null;
		
		String requestURL = httpRequest.getRequestURL().toString();
		if (!loggedIn && isLoginRequired(requestURL))
		{
			String queryString = httpRequest.getQueryString();
			String redirectURL = requestURL;
			
			if (queryString != null)
			{
				redirectURL = redirectURL.concat("?").concat(queryString);
			}
			
			session.setAttribute("redirectURL", requestURL);
			
			String loginPage = "/jsp/customer/login_form.jsp";
			request.setAttribute("message", "You must be logged first");
			RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
			dispatcher.forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
	}
	
	public boolean isLoginRequired(String requestURL)
	{
		for (String loginRequiredURL : loginRequiredURLs)
		{
			if (requestURL.contains(loginRequiredURL)) 
			{
				return true;
			}
		}
		return false;
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
	}

	@Override
	public void destroy()
	{
	}
}