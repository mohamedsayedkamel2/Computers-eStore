package com.computer.store.service.impl.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.service.DeletionService;

public class ProductDeletionService implements DeletionService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ProductRepo productRepo;
	
	public ProductDeletionService(HttpServletRequest request, HttpServletResponse response, ProductRepo productRepo)
	{
		this.request = request;
		this.response = response;
		this.productRepo = productRepo;
	}
	
	public void delete() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		productRepo.delete(productId);
		String message = "The product has been deleted successfully.";
		new ProductInfoRetriverService(request, response, productRepo).retriveInfo(message);
	}
}
