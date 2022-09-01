package com.computer.store.service.impl.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.entites.Category;
import com.computer.store.service.UpdatingService;

public class CategoryUpdateService implements UpdatingService
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryRepo categoryRepo;
	
	public CategoryUpdateService(HttpServletRequest request, HttpServletResponse response, CategoryRepo categoryRepo) {
		this.request = request;
		this.response = response;
		this.categoryRepo = categoryRepo;
	}
	
	@Override
	public void getUserPage() throws ServletException, IOException {
		Long categoryId = Long.parseLong(request.getParameter("id"));
		Category category = categoryRepo.get(categoryId);
		request.setAttribute("category", category);
		String editPage = "/jsp/admin/category/edit_category.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Long categoryId = Long.parseLong(request.getParameter("id"));
		String categoryName = request.getParameter("name");
		
		Category categoryById = categoryRepo.get(categoryId);
		Category categoryByName = categoryRepo.findByName(categoryName);
		
		if (categoryByName != null && categoryById.getId() != categoryByName.getId() ) {
			String message = "Could not update category." + " A category with name" + categoryByName + " already exists.";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/common/message.jsp");
			requestDispatcher.forward(request, response);
		}else {
			categoryById.setName(categoryName);
			categoryRepo.update(categoryById);
			String message = "Category has updated successfully.";
			new CategoryInfoReteriverService(request, response, categoryRepo).retriveInfo(message);
		}
	}
}