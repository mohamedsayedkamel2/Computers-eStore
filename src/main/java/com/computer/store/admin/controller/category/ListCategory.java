package com.computer.store.admin.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.service.CategoryService;

@WebServlet("/admin/list_category")
public class ListCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryServices = new CategoryService(request, response);
		categoryServices.listCategory();		
	}

}
