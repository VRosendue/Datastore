package com.postgres.services.franchise;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.postgres.models.Characters;
import com.postgres.models.Franchise;
import com.postgres.repositories.FranchiseRepository;



@Service
public class FranchiseServiceImpl implements FranchiseService {
	private final FranchiseRepository franchiseRepository;
	
	
	
	public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
		this.franchiseRepository = franchiseRepository;
	}



	@Override
	public Franchise findById(Integer id) {
		// TODO Auto-generated method stub
		return franchiseRepository.findById(id).get();
	}



	@Override
	public Collection<Franchise> findAll() {
		// TODO Auto-generated method stub
		return franchiseRepository.findAll();
	}



	@Override
	public Franchise add(Franchise entity) {
		// TODO Auto-generated method stub
		return franchiseRepository.save(entity);
	}



	@Override
	public Franchise update(Franchise entity) {
		// TODO Auto-generated method stub
		return franchiseRepository.save(entity);
	}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Franchise entity) {
		// TODO Auto-generated method stub
		
	}


	
}
