package com.computer.store.service.impl.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.ReviewRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Product;
import com.computer.store.repository.entites.Review;
import com.computer.store.service.CreationService;

public class ReviewCreationService implements CreationService
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ReviewRepo reviewRepo;
	
	public ReviewCreationService(HttpServletRequest request, HttpServletResponse response,ReviewRepo reviewRepo)
	{
		this.request = request;
		this.response = response;
		this.reviewRepo = reviewRepo;
	}

	@Override
	public void getUserPage() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		ProductRepo productRepo = new ProductRepo();
		Product product = productRepo.get(productId);
		
		HttpSession session = request.getSession();
		session.setAttribute("product", product);
		
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		
		Review existReview = reviewRepo.findByCustomerAndProduct(customer.getId(), productId);
		
		String targetPage = "/jsp/review/review_form.jsp";
		
		if (existReview != null) {
			request.setAttribute("review", existReview);
			targetPage = "frontend/review_info.jsp";
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
		dispatcher.forward(request, response);
	}

	@Override
	public void create() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review newReview = new Review();
		newReview.setHeadLine(headline);
		newReview.setRating(rating);
		newReview.setComment(comment);
		
		Product product = new Product();
		product.setId(productId);
		newReview.setProduct(product);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		newReview.setCustomer(customer);
		
		reviewRepo.create(newReview);
		
		String messagePage = "/jsp/admin/review/review_done.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
	}
}
