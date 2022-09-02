package com.postgres.services;

import java.util.Collection;

import org.springframework.data.repository.Repository;




public interface CrudService<T, ID> {
	
	T findById(ID id);
	Collection<T> findAll();
	T create(T newCharacter);
	T update(T entity);
	boolean deleteById(ID id);
	boolean delete(T entity);

}
