package com.postgres.services;

import java.util.Collection;

import org.springframework.data.jpa.repository.*;

public interface CrudService<T, ID> {

	T findById(ID id);
    Collection<T> findAll();
    T create(T entity);
    T update(T entity);
    void deleteById(ID id);
	
}
