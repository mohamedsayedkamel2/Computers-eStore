package com.computer.store.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.service.impl.product.ProductSearchingService;

@WebServlet("/case")
public class CaseList extends HttpServlet {
	
    private static final long serialVersionUID = -1719357074741241901L;

	public CaseList() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("category", "Case");
		ProductSearchingService service = new ProductSearchingService(request, response, new ProductRepo());
		service.getListByCategory(4L);
	}
}
