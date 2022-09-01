package com.computer.store.admin.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.review.ReviewUpdatingService;

@WebServlet("/admin/edit_review")
public class ReviewsEdit extends HttpServlet {
       
    private static final long serialVersionUID = -8496812240619499833L;

	public ReviewsEdit() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new ReviewUpdatingService(request, response, new ReviewRepo());
		service.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService service = new ReviewUpdatingService(request, response, new ReviewRepo());
		service.update();
	}

}
