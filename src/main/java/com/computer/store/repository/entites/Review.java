package com.computer.store.repository.entites;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Review
{
	@Id
	Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Product product;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	Customer customer;
	
	@Column
	int rating;
	
	@Column
	String headLine;
	
	@Column
	String comment;

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

	public Object getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Review() {
	
	}

	public Review(Long id, Product product, Customer customer, int rating, String headLine, String comment) {
		super();
		this.id = id;
		this.product = product;
		this.customer = customer;
		this.rating = rating;
		this.headLine = headLine;
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", product=" + product + ", customer=" + customer + ", rating=" + rating
				+ ", headLine=" + headLine + ", comment=" + comment + "]";
	}
	
}
