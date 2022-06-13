package com.computer.store.repository.entites;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "customer_order")
@Table(name = "customer_order")
public class Order implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column	
	Long id;
	
	@OneToOne
	Product product;
	
	@Column
	int quantity;
	
	@Column
	float subTotal;
	
	@Column
	LocalDate orderDate;
	
	@ManyToOne
	Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", quantity=" + quantity + ", subTotal=" + subTotal
				+ ", orderDate=" + orderDate + "]";
	}

	public Order(Long id, Product product, int quantity, float subTotal, LocalDate orderDate) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.orderDate = orderDate;
	}

	public Order() {
		super();
	}
}
