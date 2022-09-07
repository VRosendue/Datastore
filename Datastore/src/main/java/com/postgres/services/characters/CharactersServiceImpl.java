package com.postgres.services.characters;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postgres.models.Characters;

import com.postgres.repositories.CharactersRepository;

@Service
public class CharactersServiceImpl implements CharactersService {
	private final CharactersRepository charactersRepository;

	private final Logger logger = LoggerFactory.getLogger(CharactersServiceImpl.class);

	public CharactersServiceImpl(CharactersRepository charactersRepository) {
		this.charactersRepository = charactersRepository;
	}

	@Override
	public Characters findById(Integer id) {

		return charactersRepository.findById(id).get();

	}

	@Override
	public Collection<Characters> findAll() {
		// TODO Auto-generated method stub
		return charactersRepository.findAll();
	}

	@Override
	public Characters add(Characters entity) {
		// TODO Auto-generated method stub
		return charactersRepository.save(entity);
	}

	@Override
	public Characters update(Characters entity) {
		// TODO Auto-generated method stub
		return charactersRepository.save(entity);
	}

	

	@Override
	public void delete(Characters entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}