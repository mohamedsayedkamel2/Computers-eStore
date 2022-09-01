package com.computer.store.admin.controller.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.impl.category.CategoryInfoReteriverService;

@WebServlet("/admin/list_category")
public class ListCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCategory() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryRepo repo = new CategoryRepo();
		InfoReterivingService infoService = new CategoryInfoReteriverService(request, response, repo);
		infoService.retriveInfo(null);
	}
}
