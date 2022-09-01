package com.computer.store.admin.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.service.InfoReterivingService;
import com.computer.store.service.impl.product.ProductInfoRetriverService;

@WebServlet("/admin/list_product")
public class ProductsList extends HttpServlet {

    private static final long serialVersionUID = 2202567154810517885L;
    
	private static ProductRepo repo;
    
	public ProductsList() {
		repo = new ProductRepo();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InfoReterivingService service = new ProductInfoRetriverService(request, response, repo);
		service.retriveInfo(null);
	}
}