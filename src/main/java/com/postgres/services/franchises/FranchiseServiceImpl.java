package com.postgres.services.franchises;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import com.postgres.models.Franchise;
import com.postgres.repositories.FranchiseRepository;



@Service
public class FranchiseServiceImpl implements FranchiseService {
	
	private final FranchiseRepository franchiseRepository;
	
	public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
		super();
		this.franchiseRepository = franchiseRepository;
	}

	@Override
	public Franchise findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Franchise> findAll() {
		return franchiseRepository.findAll(); 
	}

	@Override
	public Franchise create(Franchise entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Franchise update(Franchise entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
