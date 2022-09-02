package com.postgres.services.characters;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.postgres.models.Characters;
import com.postgres.repositories.CharactersRepository;



@Service
public class CharacterServiceImpl implements CharacterService {
	private final CharactersRepository charactersRepository;
	
	
	
	public CharacterServiceImpl(CharactersRepository characterRepository) {
		this.charactersRepository = characterRepository;
	}



	@Override
	public Characters findById(Integer id) {
		// TODO Auto-generated method stub
		return charactersRepository.findById(id).get();
	}



	@Override
	public Collection<Characters> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Characters create(Characters entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Characters update(Characters entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Characters add(Characters entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Characters entity) {
		// TODO Auto-generated method stub
		
	}




	
	
}