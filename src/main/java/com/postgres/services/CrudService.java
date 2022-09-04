package com.postgres.services;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.mapping.List;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;

import com.postgres.models.dto.CharactersDTO;
import com.postgres.models.dto.MovieDTO;




public interface CrudService<T, ID> {
	
	ResponseEntity<T> findById(ID id);
	ResponseEntity<ArrayList<T>> findAll();
	ResponseEntity<T> create(T newCharacter);
	ResponseEntity<T> update(T entity, ID id);
	ResponseEntity<T> deleteById(ID id);
	
}
