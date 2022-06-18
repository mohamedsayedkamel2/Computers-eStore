package com.computer.store.service;

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

public class ProductService {
	private ProductRepo productRepo;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryRepo categoryRepo;
	
	public ProductService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		productRepo = new ProductRepo();
		categoryRepo = new CategoryRepo();
	}
	
	public void listProducts() throws ServletException, IOException {
		listProducts(null);
	}

	public void listProducts(String message) throws ServletException, IOException {
		List<Product> productsList = productRepo.listAll();
		request.setAttribute("products", productsList);
		
		if (message != null) {
			request.setAttribute("message",message);
		}
		
		String listPage = "/jsp/admin/product/product_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
		
	}
	
	
	public void showProductNewForm() throws ServletException, IOException {
		List<Category> listCategory = categoryRepo.listAll();
        request.setAttribute("categories", listCategory);
		String newPage = "/jsp/admin/product/product_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
		requestDispatcher.forward(request, response);
	}

	public void createProduct() throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Product existProduct = productRepo.findByName(name);
		
		if (existProduct != null) {
			String message = "Could not create new product because the name " + name + " already exists";
			listProducts(message);
			return;
		}
		
		Product newProduct = new Product();
		readProductFields(newProduct);
		productRepo.create(newProduct);
		String message = "A new product has been created successfully";
		request.setAttribute("message",message);
		listProducts(message);
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
	
	public void editProduct() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		Product product = productRepo.get(productId);
		List<Category> listCategory = categoryRepo.listAll();
		
		request.setAttribute("product", product);
		request.setAttribute("categories", listCategory);
		
		String editPage = "/jsp/admin/product/product_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}
	
	public void updateProduct() throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		
		Product existProduct = productRepo.get(id);
		Product productByName = productRepo.findByName(name);
		
		if (productByName != null && !existProduct.equals(productByName)) {
			String message = "Could not update Product because there's another product having same title.";
			listProducts(message);
			return;
		}
		
		existProduct.setName(name);
		productRepo.update(existProduct);
		
		String message = "The product has been updated successfully.";
		listProducts(message);
		
	}
	
	public void deleteProduct() throws ServletException, IOException {
		Long productId = Long.parseLong(request.getParameter("id"));
		productRepo.delete(productId);
		String message = "The product has been deleted successfully.";
		listProducts(message);
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
