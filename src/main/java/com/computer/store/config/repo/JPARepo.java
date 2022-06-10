package com.computer.store.config.repo;

import java.util.List;

public interface JPARepo<E> 
{
	public E create(E t);
	
	public E update(E t);
	
	public E get(Object id);
	
	public void delete(Object id);
	
	public List<E> listAll();
	
	public long count();
	
}