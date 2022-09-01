package com.computer.store.admin.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.ProductRepo;
import com.computer.store.service.CreationService;
import com.computer.store.service.impl.product.ProductCreationService;
import com.computer.store.service.impl.product.ProductInfoRetriverService;


@WebServlet("/admin/create_product")
public class ProductCreate extends HttpServlet {
	
    private static final long serialVersionUID = -7541233807397650638L;
    private static ProductRepo repo;
    
	public ProductCreate() {
		repo = new ProductRepo();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreationService service = new ProductCreationService(request, response, repo, new CategoryRepo(), new ProductInfoRetriverService(request, response, repo));
		service.getUserPage();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CreationService service = new ProductCreationService(request, response, repo, new CategoryRepo(), new ProductInfoRetriverService(request, response, repo));
		service.create();
	}

}
