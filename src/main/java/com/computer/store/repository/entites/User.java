package com.computer.store.repository.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String email;
	
	@Column
	String password;
	
	@Column
	String fullName;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getFullName() 
	{
		return fullName;
	}
	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}
	public User() {
	}
	public User(Long id, String email, String password, String fullName) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName + "]";
	}
	
}
