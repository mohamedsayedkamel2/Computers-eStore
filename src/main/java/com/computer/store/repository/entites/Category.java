package com.computer.store.repository.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "productCategory", fetch = FetchType.LAZY)
	List<Product>productList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getList() {
		return productList;
	}

	public void setList(List<Product> list) {
		this.productList = list;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", list=" + productList + "]";
	}

	public Category(Long id, String name, List<Product> list) {
		super();
		this.id = id;
		this.name = name;
		this.productList = list;
	}

	public Category() {
		super();
	}
	
	
}
