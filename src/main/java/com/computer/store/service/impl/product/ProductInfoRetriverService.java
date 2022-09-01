package com.computer.store.service.impl.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Product;
import com.computer.store.service.InfoReterivingService;

public class ProductInfoRetriverService implements InfoReterivingService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ProductRepo productRepo;
	
	public ProductInfoRetriverService(HttpServletRequest request, HttpServletResponse response, ProductRepo productRepo)
	{
		this.request = request;
		this.response = response;
		this.productRepo = productRepo;
	}

	@Override
	public void retriveInfo(String message) throws ServletException, IOException {
		List<Product> productsList = productRepo.listAll();
		request.setAttribute("products", productsList);
		
		if (message != null) {
			request.setAttribute("message",message);
		}
		
		String listPage = "/jsp/admin/product/product_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
}
