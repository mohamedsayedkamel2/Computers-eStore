package com.computer.store.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.service.impl.product.ProductSearchingService;

@WebServlet("/hdd")
public class HardDiskList extends HttpServlet {
	       
    private static final long serialVersionUID = -6177189048861846198L;

	public HardDiskList() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("category", "Computer Storage");
		ProductSearchingService service = new ProductSearchingService(request, response, new ProductRepo());
		service.getListByCategory(2L);
	}
}
