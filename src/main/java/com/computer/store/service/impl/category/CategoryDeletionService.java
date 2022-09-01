package com.computer.store.service.impl.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.service.DeletionService;

public class CategoryDeletionService implements DeletionService
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryRepo categoryRepo;
	
	public CategoryDeletionService(HttpServletRequest request, HttpServletResponse response, CategoryRepo categoryRepo)
	{
		this.request = request;
		this.response = response;
		this.categoryRepo = categoryRepo;
	}
	
	public void delete() throws ServletException, IOException {
		Long categoryId = Long.parseLong(request.getParameter("id"));
		categoryRepo.delete(categoryId);
		String message = "The category with ID " + categoryId + " has been removed successfully";
		new CategoryInfoReteriverService(request, response, categoryRepo).retriveInfo(message);
	}
}