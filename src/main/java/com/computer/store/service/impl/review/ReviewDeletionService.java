package com.computer.store.service.impl.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.service.DeletionService;

public class ReviewDeletionService implements DeletionService
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ReviewRepo reviewRepo;
	
	public ReviewDeletionService(HttpServletRequest request, HttpServletResponse response,ReviewRepo reviewRepo)
	{
		this.request = request;
		this.response = response;
		this.reviewRepo = reviewRepo;
	}

	@Override
	public void delete() throws ServletException, IOException {
		Long reviewId = Long.parseLong(request.getParameter("id"));
		reviewRepo.delete(reviewId);
		
		String message = "The review has been deleted successfully.";
		
		new ReviewInfoRetriverService(request, response, reviewRepo).retriveInfo(message);
	}
}
