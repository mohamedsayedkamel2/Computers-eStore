package com.computer.store.admin.controller.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.CategoryService;

@WebServlet("/admin/create_category")
public class CreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryCreatePage = "/jsp/admin/category/category_create.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryCreatePage);
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryServices = new CategoryService(request, response);
		categoryServices.createCategory();
	}

}
