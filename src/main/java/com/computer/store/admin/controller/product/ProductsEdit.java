package com.computer.store.admin.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.ProductRepo;
import com.computer.store.service.UpdatingService;
import com.computer.store.service.impl.product.ProductInfoRetriverService;
import com.computer.store.service.impl.product.ProductUpdateService;

@WebServlet("/admin/edit_product")
public class ProductsEdit extends HttpServlet {
	
    private static final long serialVersionUID = -1349113951272533736L;
    
	private static ProductRepo repo;
    
	public ProductsEdit() {
		ProductRepo repo = new ProductRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService serivce = new ProductUpdateService(request, response, repo, new CategoryRepo(), new ProductInfoRetriverService(request, response, repo));
		serivce.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdatingService serivce = new ProductUpdateService(request, response, repo, new CategoryRepo(), new ProductInfoRetriverService(request, response, repo));
		serivce.update();
	}

}
