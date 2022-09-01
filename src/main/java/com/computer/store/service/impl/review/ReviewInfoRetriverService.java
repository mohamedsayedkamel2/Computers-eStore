package com.computer.store.service.impl.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.repository.entites.Review;
import com.computer.store.service.InfoReterivingService;

public class ReviewInfoRetriverService implements InfoReterivingService
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ReviewRepo reviewRepo;
	
	public ReviewInfoRetriverService(HttpServletRequest request, HttpServletResponse response,ReviewRepo reviewRepo)
	{
		this.request = request;
		this.response = response;
		this.reviewRepo = reviewRepo;
	}

	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		List<Review> reviewsList = reviewRepo.listAll();
		
		request.setAttribute("reviews", reviewsList);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "/jsp/admin/review/review_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}
	
}
