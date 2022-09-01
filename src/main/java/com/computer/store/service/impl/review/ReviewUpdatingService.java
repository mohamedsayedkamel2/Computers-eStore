package com.computer.store.service.impl.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.repository.entites.Review;
import com.computer.store.service.UpdatingService;

public class ReviewUpdatingService implements UpdatingService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ReviewRepo reviewRepo;
	
	public ReviewUpdatingService(HttpServletRequest request, HttpServletResponse response,ReviewRepo reviewRepo)
	{
		this.request = request;
		this.response = response;
		this.reviewRepo = reviewRepo;
	}
	
	@Override
	public void getUserPage() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		Review review = reviewRepo.get(reviewId);
		
		request.setAttribute("review", review);
		
		String editPage = "/jsp/admin/review/review_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		String headline = request.getParameter("headline");		
		Review review = reviewRepo.get(reviewId);
		review.setHeadLine(headline);
		
		reviewRepo.update(review);
		
		String message = "The review has been updated successfully.";
		
		new ReviewInfoRetriverService(request, response, reviewRepo).retriveInfo(message);
	}
}
