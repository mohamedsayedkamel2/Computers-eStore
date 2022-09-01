package com.computer.store.admin.controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ReviewRepo;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.impl.review.ReviewInfoRetriverService;

@WebServlet("/admin/list_review")
public class ListReviews extends HttpServlet {
       
    private static final long serialVersionUID = 6090308717096245853L;

	public ListReviews() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoReterivingService service = new ReviewInfoRetriverService(request, response, new ReviewRepo());
		service.retriveInfo(null);
	}

}
