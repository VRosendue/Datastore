package com.postgres.services.characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.postgres.models.Characters;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.models.dto.MovieDTO;
import com.postgres.models.dto.MoviesDTO;
import com.postgres.repositories.CharactersRepository;
import com.postgres.utils.HelperService;

import no.accelerate.restserverdemo.models.Professor;
import no.accelerate.restserverdemo.services.professor.ProfessorServiceImpl;

@Service
public class CharacterServiceImpl implements CharacterService {

	@Autowired
	private MovieDTO movieDTO;

	@Autowired
	private CharactersRepository characterRepository;

	private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

	@Override
	public ResponseEntity<CharactersDTO> findById(Integer id) {
		HttpStatus httpStatus = null;
		CharactersDTO returnCharacter = null;

		try {
			if ((returnCharacter = characterRepository.getReferenceById(id)) != null) {
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<>(returnCharacter, httpStatus);
	}

	@Override
	public ResponseEntity<ArrayList<CharactersDTO>> findAll() {
		ArrayList<CharactersDTO> returnAll = null;
		HttpStatus httpStatus = null;

		try {
			returnAll = (ArrayList<CharactersDTO>) characterRepository.findAll();
			if ((returnAll.isEmpty())) {
				httpStatus = HttpStatus.NOT_FOUND;
			} else {
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			httpStatus = httpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnAll, httpStatus);
	}

	@Override
	public ResponseEntity<CharactersDTO> create(CharactersDTO newCharacter) {
		HttpStatus httpStatus = null;
		CharactersDTO returnCharacter = null;

		try {
			if ((returnCharacter = characterRepository.getCharacterFullName(newCharacter.getFullName())) != null) {
				returnCharacter = characterRepository.saveAndFlush(newCharacter);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				System.out.println("Character already exist");
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<>(returnCharacter, httpStatus);
	}

	@Override
	public ResponseEntity<CharactersDTO> update(CharactersDTO entity, Integer id) {
		HttpStatus httpStatus = null;
		CharactersDTO characterDTO = null;

		try {
			if ((characterDTO = characterRepository.getReferenceById(id)) != null) {
				entity = (CharactersDTO) HelperService.partialUpdate(characterDTO, entity);
				characterDTO = characterRepository.saveAndFlush(entity);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				System.out.println("Cant find character");
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(characterDTO, httpStatus);
	}

	@Transactional
	@Override
	public ResponseEntity<CharactersDTO> deleteById(Integer id) {
		HttpStatus httpStatus = null;
		CharactersDTO characterDTO = null;

		try {
			if ((characterDTO = characterRepository.getReferenceById(id)) != null) {
				characterDTO.getMovies().forEach(s -> movieDTO.setCharacters(null));
				characterDTO = characterRepository.saveAndFlush(characterDTO);
				characterRepository.deleteById(id);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(characterDTO, httpStatus);
	}
}