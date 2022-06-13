package com.computer.store.admin.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.ReviewService;


@WebServlet("/admin/delete_review")
public class ReviewDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ReviewDelete() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewService reviewService = new ReviewService(request, response);
		reviewService.deleteReview();
	}
}
