package com.computer.store.admin.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.category.CategoryUpdateService;

@WebServlet("/admin/edit_category")
public class EditCategory extends HttpServlet {
       
    private static final long serialVersionUID = -5066436694800876780L;
    
	private static CategoryRepo repo;

	public EditCategory() {
		repo = new CategoryRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService updateService = new CategoryUpdateService(request, response, repo);
		updateService.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService updateService = new CategoryUpdateService(request, response, repo);
		updateService.update();
	}
}