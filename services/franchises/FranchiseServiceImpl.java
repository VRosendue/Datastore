package com.postgres.services.franchises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.postgres.models.Franchise;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.models.dto.FranchiseDTO;
import com.postgres.models.dto.MovieDTO;
import com.postgres.repositories.FranchiseRepository;
import com.postgres.utils.HelperService;



@Service
public class FranchiseServiceImpl implements FranchiseService {
	
	@Autowired
	private MovieDTO movieDTO;
	
	@Autowired
	private FranchiseRepository franchiseRepository;

	@Override
	public ResponseEntity<FranchiseDTO> findById(Integer id) {
		HttpStatus httpStatus = null;
		FranchiseDTO returnDTO = null;

		try {
			if ((returnDTO = franchiseRepository.getReferenceById(id)) != null) {
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
	public ResponseEntity<ArrayList<FranchiseDTO>> findAll() {
		ArrayList<FranchiseDTO> returnAll = null;
		HttpStatus httpStatus = null;

		try {
			returnAll = (ArrayList<FranchiseDTO>) franchiseRepository.findAll();
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
	public ResponseEntity<FranchiseDTO> create(FranchiseDTO newDTO) {
		HttpStatus httpStatus = null;
		FranchiseDTO returnDTO = null;

		try {
			if ((returnDTO = franchiseRepository.getFranchiseName(newDTO.getName())) != null) {
				returnDTO = franchiseRepository.saveAndFlush(newDTO);
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
	public ResponseEntity<FranchiseDTO> update(FranchiseDTO entity, Integer id) {
		HttpStatus httpStatus = null;
		FranchiseDTO returnDTO = null;

		try {
			if ((returnDTO = franchiseRepository.getReferenceById(id)) != null) {
				entity = (FranchiseDTO) HelperService.partialUpdate(returnDTO, entity);
				returnDTO = franchiseRepository.saveAndFlush(entity);
				httpStatus = HttpStatus.OK;
			} else {
				httpStatus = HttpStatus.BAD_REQUEST;
				System.out.println("Cant find character");
			}
		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<>(returnDTO, httpStatus);
	}

	@Override
	public ResponseEntity<FranchiseDTO> deleteById(Integer id) {
		HttpStatus httpStatus = null;
		FranchiseDTO returnDTO = null;

		try {
			if ((returnDTO = franchiseRepository.getReferenceById(id)) != null) {
				returnDTO.getMovies().forEach(s -> movieDTO.setFranchise(null));
				returnDTO = franchiseRepository.save(returnDTO);
				franchiseRepository.deleteById(id);
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
