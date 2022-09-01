package com.computer.store.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.service.CreationService;
import com.computer.store.service.impl.review.ReviewCreationService;


@WebServlet("/write_review")
public class WriteReview extends HttpServlet {
       
    private static final long serialVersionUID = -2849303714402962275L;

	public WriteReview() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreationService service = new ReviewCreationService(request, response, new ReviewRepo());
		service.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreationService service = new ReviewCreationService(request, response, new ReviewRepo());
		service.create();
	}
}
