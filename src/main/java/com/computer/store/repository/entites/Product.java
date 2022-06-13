package com.computer.store.repository.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
	@NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
	@NamedQuery(name = "Product.countAll", query = "SELECT COUNT(*) FROM Product p"),
	@NamedQuery(name = "Product.countByCategory", query = "SELECT COUNT(p) FROM Product p"
	+ " WHERE p.productCategory.id = :categoryId"),
	@NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p JOIN" 
	+ " Category c ON p.productCategory.id = c.id AND c.id = :categoryId"),
	@NamedQuery(name = "Product.search", query = "SELECT p FROM Product p WHERE p.name Like '%' || :keyword || '%'")
})
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	Category productCategory;
	
	@Column
	String name;
	
	@Column
	String description;
	
	@Column
	String imgUrl;
	
	@Column
	float price;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "product")
	List<Review> reviewList;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public List<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productCategory=" + productCategory.name + ", name=" + name + ", description="
				+ description + ", imgUrl=" + imgUrl + ", price=" + price + ", reviewList=" + reviewList + "]";
	}
	public Product(Long id, Category productCategory, String name, String description, String imgUrl, float price,
			List<Review> reviewList) {
		super();
		this.id = id;
		this.productCategory = productCategory;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
		this.price = price;
		this.reviewList = reviewList;
	}
	public Product() {
		super();
	}
	
}
