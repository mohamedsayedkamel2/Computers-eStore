package com.computer.store.controller.product.payment;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.ProductRepo;
import com.computer.store.repository.entites.Customer;
import com.computer.store.repository.entites.Order;
import com.computer.store.repository.entites.Product;
import com.computer.store.service.PaymentService;

@WebServlet("/buy_product")
public class BuyProduct extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public BuyProduct() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepo repo = new ProductRepo();
		Long productId = Long.parseLong(request.getParameter("id"));
		Product p = repo.get(productId);
		request.setAttribute("product", p);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/payment/payment_page.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentService paymentService = new PaymentService(request, response);
		paymentService.buyProduct();
	}

}
