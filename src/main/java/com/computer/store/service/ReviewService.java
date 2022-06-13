package com.computer.store.service;

import java.io.IOException;
import java.util.List;

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

public class ReviewService {
	private ReviewRepo reviewRepo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ReviewService(HttpServletRequest request, HttpServletResponse response) {
		this.reviewRepo = new ReviewRepo();
		this.request = request;
		this.response = response;
	}
	
	public void listAllReview() throws ServletException, IOException {
		listAllReview(null);
	}
	
	public void listAllReview(String message) throws ServletException, IOException {
		List<Review> reviewsList = reviewRepo.listAll();
		
		request.setAttribute("reviews", reviewsList);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "/jsp/admin/review/review_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void getEditForm() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		Review review = reviewRepo.get(reviewId);
		
		request.setAttribute("review", review);
		
		String editPage = "/jsp/admin/review/review_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateReview() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		String headline = request.getParameter("headline");		
		Review review = reviewRepo.get(reviewId);
		review.setHeadLine(headline);
		
		reviewRepo.update(review);
		
		String message = "The review has been updated successfully.";
		
		listAllReview(message);
	}

	public void deleteReview() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		reviewRepo.delete(reviewId);
		
		String message = "The review has been deleted successfully.";
		
		listAllReview(message);
	}

	public void showReviewForm() throws ServletException, IOException {
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

	public void submitReview() throws ServletException, IOException {
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
