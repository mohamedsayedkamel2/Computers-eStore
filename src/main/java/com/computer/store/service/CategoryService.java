package com.computer.store.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.entites.Category;

public class CategoryService {
	private CategoryRepo categoryRepo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CategoryService(HttpServletRequest request, HttpServletResponse response) {
		categoryRepo = new CategoryRepo();
		this.request = request;
		this.response = response;
	}
	
	public void listCategory(String message) throws ServletException, IOException {
		  // Will get all the categories from the DB
		  List<Category> listCategory= categoryRepo.listAll();
		  // Add the categories to the request scope
		  request.setAttribute("categories", listCategory); 
		  
		  if (message != null) {
			  request.setAttribute("message", message);
		  }
		  
		  String listPage = "/jsp/admin/category/category_list.jsp";
		  RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
			
		  requestDispatcher.forward(request, response);
		}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void createCategory() throws ServletException, IOException {
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
			listCategory(message);
		}
	}
	
	public void editCategory() throws ServletException, IOException {
		Long categoryId = Long.parseLong(request.getParameter("id"));
		Category category = categoryRepo.get(categoryId);
		request.setAttribute("category", category);
		String editPage = "/jsp/admin/category/edit_category.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
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
			listCategory(message);
		}
	}
	public void deleteCategory() throws ServletException, IOException {
		Long categoryId = Long.parseLong(request.getParameter("id"));
		categoryRepo.delete(categoryId);
		String message = "The category with ID " + categoryId + " has been removed successfully";
		listCategory(message);
	}
}
