package com.postgres.services.characters;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.postgres.models.Characters;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.repositories.CharactersRepository;



@Service
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	private CharactersRepository characterRepository;


	@Override
	public CharactersDTO findById(Integer id) {
		return characterRepository.findById(id).get();
	}



	@Override
	public Collection<CharactersDTO> findAll() {
		return characterRepository.findAll();
		}

	@Override
	public ResponseEntity<CharacterDTO> create(CharactersDTO newCharacter) {
		HttpStatus httpStatus;
		CharactersDTO returnCharacter;
		
		try {
			if (returnCharacter = characterRepository.getCharacterFullName(newCharacter.getFullName()) != null) {
				returnCharacter = characterRepository.saveAndFlush(newCharacter);
				httpStatus = HttpStatus.OK;
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<>(returnCharacter, httpStatus);
	}



	@Override
	public CharactersDTO create1(CharactersDTO newCharacter) {
		HttpStatus httpStatus;
		CharactersDTO returnCharacter;
		
		try {
			if (returnCharacter = characterRepository.getCharacterFullName(newCharacter.getFullName()) != null) {
				returnCharacter = characterRepository.saveAndFlush(newCharacter);
				httpStatus = HttpStatus.OK;
			}else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new returnContact;
	}



	@Override
	public CharactersDTO update(CharactersDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(CharactersDTO entity) {
		// TODO Auto-generated method stub
		return false;
	}











	
	
}