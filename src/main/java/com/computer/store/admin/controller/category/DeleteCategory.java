package com.computer.store.admin.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.CategoryService;

@WebServlet("/admin/delete_category")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryService(request, response);
		categoryService.deleteCategory();
	}


}
