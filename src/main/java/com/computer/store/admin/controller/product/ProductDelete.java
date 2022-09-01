package com.computer.store.admin.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.service.DeletionService;
import com.computer.store.service.impl.product.ProductDeletionService;


@WebServlet("/admin/delete_product")
public class ProductDelete extends HttpServlet {
       
    private static final long serialVersionUID = 2356775550101166715L;
    private static ProductRepo repo;
    
	public ProductDelete() {
		ProductRepo repo = new ProductRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeletionService service = new ProductDeletionService(request, response, repo);
		service.delete();
	}


}
