package com.computer.store.service.impl.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.entites.Category;
import com.computer.store.service.InfoReterivingService;

public class CategoryInfoReteriverService implements InfoReterivingService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryRepo categoryRepo;

	public CategoryInfoReteriverService(HttpServletRequest request, HttpServletResponse response, CategoryRepo categoryRepo) {
		this.request = request;
		this.response = response;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		// Will get all the categories from the DB
		List<Category> listCategory = categoryRepo.listAll();
		// Add the categories to the request scope
		request.setAttribute("categories", listCategory);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "/jsp/admin/category/category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);
	}
}