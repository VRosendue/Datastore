package com.postgres.services;

import java.util.Collection;

import org.springframework.data.repository.Repository;




public interface CrudService<T, ID> {
	
	T findById(ID id);
	Collection<T> findAll();
	T create(T entity);
	T update(T entity);
	T add(T entity);
	void deleteById(ID id);
	void delete(T entity);

}
