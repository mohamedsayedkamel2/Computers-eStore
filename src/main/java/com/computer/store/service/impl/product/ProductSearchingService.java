package com.computer.store.service.impl.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Product;

public class ProductSearchingService 
{
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ProductRepo productRepo;
	
	public ProductSearchingService(HttpServletRequest request, HttpServletResponse response,ProductRepo productRepo)
	{
		this.request = request;
		this.response = response;
		this.productRepo = productRepo;
	}
	
	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Product> result = null;
		if (keyword.equals("")) {
			result = productRepo.listAll();
		} else {
			result = productRepo.search(keyword);
		}
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("result", result);
		
		String resultPage = "/jsp/admin/product/search_result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
		requestDispatcher.forward(request, response);
	}
	
	public void getListByCategory(Long categoryId) throws ServletException, IOException {
		List<Product> result = productRepo.listByCategory(categoryId);
		System.out.println(result);
		request.setAttribute("results", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/product/list_product.jsp");
		requestDispatcher.forward(request, response);
	}
}
