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
import com.computer.store.service.CreationService;
import com.computer.store.service.InfoReterivingService;

public class ProductCreationService implements CreationService {
	
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final InfoReterivingService infoReterivingService;
	
	public ProductCreationService(HttpServletRequest request, HttpServletResponse response, ProductRepo productRepo, CategoryRepo categoryRepo, InfoReterivingService infoReterivingService)
	{
		this.request = request;
		this.response = response;
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.infoReterivingService = infoReterivingService;
	}
	
	@Override
	public void getUserPage() throws ServletException, IOException {
		List<Category> listCategory = categoryRepo.listAll();
        request.setAttribute("categories", listCategory);
		String newPage = "/jsp/admin/product/product_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);
	}

	@Override
	public void create() throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Product existProduct = productRepo.findByName(name);
		
		if (existProduct != null) {
			String message = "Could not create new product because the name " + name + " already exists";
			infoReterivingService.retriveInfo(message);
			return;
		}
		
		Product newProduct = new Product();
		readProductFields(newProduct);
		productRepo.create(newProduct);
		String message = "A new product has been created successfully";
		request.setAttribute("message",message);
		infoReterivingService.retriveInfo(message);
	}
	
	public void readProductFields(Product product) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		Long categoryId = Long.parseLong(request.getParameter("category"));
		String imgUrl = request.getParameter("img_url");
		
		
		Category category = categoryRepo.get(categoryId);
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setProductCategory(category);
		product.setImgUrl(imgUrl);
	}
}
