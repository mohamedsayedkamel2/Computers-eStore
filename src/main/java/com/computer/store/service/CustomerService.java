package com.computer.store.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.computer.store.repository.CustomerRepo;
import com.computer.store.repository.entites.Customer;

public class CustomerService {
	private CustomerRepo customerRepo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		customerRepo = new CustomerRepo();
		this.request = request;
		this.response = response;
	}
	
	public void listCustomer(String message) throws ServletException, IOException {
		List<Customer> customersList = customerRepo.listAll();
		request.setAttribute("customers", customersList);
		request.setAttribute("message", message);
		
		String listPage = "/jsp/admin/customer/list_customer.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCustomer() throws ServletException, IOException {
		listCustomer(null);
	}
	
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerRepo.findByEmail(email);
		
		if (existCustomer != null) {
			String message = "Could not create new customer: the email "
					+ email + " is already registered by another customer";
			listCustomer(message);
		}
		else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
			customerRepo.create(newCustomer);
			
			String message = "New customer has been created successfully";
			listCustomer(message);
		}
	}
	
	private void updateCustomerFieldsFromForm(Customer customer) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String password = request.getParameter("password");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}

		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}
		
		customer.setName(name);
		customer.setCountry(country);
		customer.setCity(city);
		customer.setRegisterationDate(LocalDate.now());
	}
	

	
	public void getEditCustomerAdminPage() throws ServletException, IOException {
		Long customerId = Long.parseLong(request.getParameter("id"));
		Customer customer = customerRepo.get(customerId);
		
		request.setAttribute("customer", customer);
		
		String editPage = "/jsp/admin/customer/customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCustomer() throws ServletException, IOException {
		Long customerId = Long.parseLong(request.getParameter("id"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerRepo.findByEmail(email);
		String message = null;
		
		if (customerByEmail != null && customerByEmail.getId() != customerId) {
		    message = "Could not update the customer ID " + customerId 
					+ " because there's an existing customer having the same email.";
		}else {
			
			Customer customerById = customerRepo.get(customerId);
			updateCustomerFieldsFromForm(customerById);
			customerRepo.update(customerById);
			
			message = "The customer is successfully updated.";
		}
		listCustomer(message);
		
	}
	
	public void deleteCustomer() throws ServletException, IOException {
		Long customerId = Long.parseLong(request.getParameter("id"));
		customerRepo.delete(customerId);
		
		String message = "The customer has been deleted.";
		listCustomer(message);
	}

	public void ShowCustomerRegisterForm() throws ServletException, IOException {
		String registerForm = "/jsp/customer/register_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(registerForm);
		dispatcher.forward(request, response);
	}
	
	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerRepo.findByEmail(email);
		String message = "";
		
		if (existCustomer != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another customer";
		}
		else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromForm(newCustomer);
			
			customerRepo.create(newCustomer);
			
			message = "You have been created successfully, thank you!<br/>"
					+ "<a href='/Computers4Sale/login'>Click here</a> to login";
		}
		
		String messagePage = "/jsp/common/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		requestDispatcher.forward(request, response);
	}
	
	public void showLoginPage() throws ServletException, IOException {
		String loginPage = "/jsp/customer/login_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}
	
	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerRepo.checkLogin(email, password);
		
		if (customer == null) {
			String message = "Login failed. Please check your email and password";
			request.setAttribute("message", message);
			showLoginPage();
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			
			Object objRedictedURL = session.getAttribute("redirectURL");
			
			if (objRedictedURL != null) {
				String redirectURL = (String) objRedictedURL;
				session.removeAttribute(redirectURL);
				response.sendRedirect(redirectURL);
			}else {
				showCustomerProfile();
			}
		}
	}
	
	public void showCustomerProfile() throws ServletException, IOException {

		String profilePage = "/jsp/customer/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage = "/jsp/customer/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromForm(customer);
		customerRepo.update(customer);
		showCustomerProfile();
	}
}
