package com.postgres.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import com.postgres.models.Franchise;
import com.postgres.models.dto.CharactersDTO;




public interface CrudService<T, ID> {
	
	T findById(ID id);
	Collection<T> findAll();
	T add(T entity);
	T update(T entity);
	void deleteById(ID id);
	void delete(T entity);
	
}
