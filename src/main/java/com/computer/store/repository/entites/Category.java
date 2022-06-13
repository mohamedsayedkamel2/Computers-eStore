package com.computer.store.repository.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c ORDER BY id"),
	@NamedQuery(name = "Category.countAll", query = "SELECT COUNT(*) FROM Category"),
	@NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name")
})
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String name;
	
	@OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER)
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
		return name;
	}

	public Category(Long id, String name, List<Product> list) {
		super();
		this.id = id;
		this.name = name;
		this.productList = list;
	}

	public Category() {
	}
	
	
}
