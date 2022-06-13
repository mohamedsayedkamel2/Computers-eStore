package com.computer.store.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.computer.store.repository.entites.Order;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentService {
	private final String CLIENT_ID = "AamyfKnRFfVb12o8EVUzBAWMJEgHUfV7kW5jDVLT6Dk6aotEOKiB5bmUXBPCBWrRdRffb_o-rQH0ovuI";
	private final String CLIENT_SECRET = "EOjlRHfu07tMeWbrewXhJ893CY3uL3SlfLyRsyikt6az2JC_kheuX7cU-2avFr9qOw301uElUGS74reX";
	private final String mode = "sandbox";
	HttpServletRequest request;
	HttpServletResponse response;
	
	public PaymentService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void authorizePayment(Order order) throws PayPalRESTException {
		// Set payer info
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName(order.getCustomer().getName());
		payerInfo.setLastName("");
		payer.setPayerInfo(payerInfo);
		
		// Set the cancel & return url
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String baseUrl = requestUrl.replace(requestUri, "").concat(request.getContextPath());
		String cancelUrl = baseUrl.concat("/");
		String returnUrl = baseUrl.concat("/review_payment");
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl(baseUrl);
		redirectUrls.setReturnUrl(baseUrl);
		
		Details details = new Details();
		String subTotal = Float.toString(order.getSubTotal());
		subTotal = subTotal.format("%.2f", subTotal);
		details.setSubtotal(subTotal);
		
		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setDetails(details);
		amount.setTotal(subTotal);
		ShippingAddress shippingAddress = new ShippingAddress();
		shippingAddress.setRecipientName(order.getCustomer().getName());
		
		Transaction transaction = new Transaction();
		transaction.setDescription("A product");
		transaction.setAmount(amount);
		
		ItemList itemList = new ItemList();
		itemList.setShippingAddress(shippingAddress);
		
		List<Item> paypalItems = new ArrayList();
		Item paypalItem = new Item();
		paypalItem.setCurrency("USD").setName(order.getProduct().getName())
		.setQuantity(Integer.toString(order.getQuantity()))
		.setPrice(subTotal);
		paypalItems.add(paypalItem);
		transaction.setItemList(itemList);
		
		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);
		
		Payment requestPayment = new Payment();
		requestPayment.setPayer(payer).setRedirectUrls(redirectUrls).setIntent("authorize").setTransactions(listTransaction);
		
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, mode);
		Payment authorizedPayment = requestPayment.create(apiContext);
		System.out.println(returnUrl);
		System.out.println(cancelUrl);
		System.out.println("Authroized payment");
		System.out.println(authorizedPayment);
		}
	
}
