package com.computer.store.admin.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.service.DeletionService;
import com.computer.store.service.impl.review.ReviewDeletionService;


@WebServlet("/admin/delete_review")
public class ReviewDelete extends HttpServlet {
	
    private static final long serialVersionUID = -439550393465910221L;

	public ReviewDelete() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeletionService service = new ReviewDeletionService(request, response, new ReviewRepo());
		service.delete();
	}
}
