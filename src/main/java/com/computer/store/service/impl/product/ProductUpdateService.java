package com.computer.store.service.impl.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.CategoryRepo;
import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Category;
import com.computer.store.repository.entites.Product;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.UpdatingService;

public class ProductUpdateService implements UpdatingService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final InfoReterivingService infoReterivingService;
	
	public ProductUpdateService(HttpServletRequest request, HttpServletResponse response, ProductRepo productRepo, CategoryRepo categoryRepo, InfoReterivingService infoReterivingService)
	{
		this.request = request;
		this.response = response;
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.infoReterivingService = infoReterivingService;
	}
	
	@Override
	public void getUserPage() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		Product product = productRepo.get(productId);
		List<Category> listCategory = categoryRepo.listAll();
		
		request.setAttribute("product", product);
		request.setAttribute("categories", listCategory);
		
		String editPage = "/jsp/admin/product/product_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	@Override
	public void update() throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		
		Product existProduct = productRepo.get(id);
		Product productByName = productRepo.findByName(name);
		
		if (productByName != null && !existProduct.equals(productByName)) {
			String message = "Could not update Product because there's another product having same title.";
			infoReterivingService.retriveInfo(message);
			return;
		}
		
		existProduct.setName(name);
		productRepo.update(existProduct);
		
		String message = "The product has been updated successfully.";
		infoReterivingService.retriveInfo(message);
	}
}
