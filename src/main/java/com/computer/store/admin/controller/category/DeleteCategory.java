package com.computer.store.admin.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.service.DeletionService;
import com.computer.store.service.impl.category.CategoryDeletionService;

@WebServlet("/admin/delete_category")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryRepo repo = new CategoryRepo();
		DeletionService deletionService = new CategoryDeletionService(request, response, repo);
		deletionService.delete();
	}


}
