package com.computer.store.service.impl.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.entites.Category;
import com.computer.store.service.CreationService;

public class CategoryCreationService implements CreationService
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final CategoryRepo categoryRepo;
	
	public CategoryCreationService(HttpServletRequest request, HttpServletResponse response,CategoryRepo categoryRepo)
	{
		this.request = request;
		this.response = response;
		this.categoryRepo = categoryRepo;
	}
	
	@Override
	public void create() throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		Category existCategory = categoryRepo.findByName(name);
		
		if (existCategory != null) {
			String message = "Could not create category." + " A category with name" + name + "already exist";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/common/message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Category newCategory = new Category();
			newCategory.setName(name);
			categoryRepo.create(newCategory);
			String message = "New Category created successfully";
			new CategoryInfoReteriverService(request, response, categoryRepo).retriveInfo(message);
		}
	}

	@Override
	public void getUserPage() throws ServletException, IOException
	{
		String categoryCreatePage = "/jsp/admin/category/category_create.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryCreatePage);
		requestDispatcher.forward(request, response);
	}
}