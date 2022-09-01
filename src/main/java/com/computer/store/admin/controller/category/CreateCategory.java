package com.computer.store.admin.controller.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.service.CreationService;
import com.computer.store.service.impl.category.CategoryCreationService;

@WebServlet("/admin/create_category")
public class CreateCategory extends HttpServlet {
	
	private static final long serialVersionUID = -5224327921071798421L;
	
	private CategoryRepo categoryRepo;
       
    public CreateCategory()
    {
    	categoryRepo = new CategoryRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CreationService categoryCreationService = new CategoryCreationService(request, response, categoryRepo);
		categoryCreationService.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CategoryCreationService categoryCreationService = new CategoryCreationService(request, response, categoryRepo);
		categoryCreationService.create();
	}
}