package com.postgres.services.movies;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.postgres.models.Movies;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.models.dto.FranchiseDTO;
import com.postgres.models.dto.MovieDTO;
import com.postgres.repositories.MovieRepository;
import com.postgres.utils.HelperService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	CharactersDTO characterDTO;

	@Autowired
	FranchiseDTO franchiseDTO;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public ResponseEntity<MovieDTO> findById(Integer id) {
		HttpStatus httpStatus = null;
		MovieDTO returnDTO = null;

		try {
			if ((returnDTO = movieRepository.getReferenceById(id)) != null) {
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}

		return new ResponseEntity<>(returnDTO, httpStatus);

	}

	@Override
	public ResponseEntity<ArrayList<MovieDTO>> findAll() {
		ArrayList<MovieDTO> returnAll = null;
		HttpStatus httpStatus = null;

		try {
			returnAll = (ArrayList<MovieDTO>) movieRepository.findAll();
			if ((returnAll.isEmpty())) {
				httpStatus = HttpStatus.NOT_FOUND;
			} else {
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println("House is on fire.");
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnAll, httpStatus);
	}

	@Override
	public ResponseEntity<MovieDTO> create(MovieDTO newDTO) {
		HttpStatus httpStatus = null;
		MovieDTO returnDTO = null;

		try {
			if ((returnDTO = movieRepository.getMovieTitle(newDTO.getMovieTitle())) != null) {
				returnDTO = movieRepository.saveAndFlush(newDTO);
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

		return new ResponseEntity<>(returnDTO, httpStatus);
	}

	@Override
	public ResponseEntity<MovieDTO> update(MovieDTO entity, Integer id) {
		HttpStatus httpStatus = null;
		MovieDTO returnDTO = null;

		try {
			if ((returnDTO = movieRepository.getReferenceById(id)) != null) {
				entity = (MovieDTO) HelperService.partialUpdate(returnDTO, entity);
				returnDTO = movieRepository.saveAndFlush(entity);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				System.out.println("Cant find character");
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnDTO, httpStatus);	}

	@Override
	public ResponseEntity<MovieDTO> deleteById(Integer id) {
		HttpStatus httpStatus = null;
		MovieDTO returnDTO = null;

		try {
			if ((returnDTO = movieRepository.getReferenceById(id)) != null) {
				returnDTO.getCharacters().forEach(s -> characterDTO.setMovies(null));
				returnDTO.getFranchise().forEach(s -> franchiseDTO.setMovies(null));
				returnDTO = movieRepository.saveAndFlush(returnDTO);
				movieRepository.deleteById(id);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnDTO, httpStatus);
	}

}
