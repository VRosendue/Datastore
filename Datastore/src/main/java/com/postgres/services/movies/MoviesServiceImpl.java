package com.postgres.services.movies;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.postgres.models.Movies;
import com.postgres.repositories.MoviesRepository;



@Service
public class MoviesServiceImpl implements MoviesService {
	private final MoviesRepository moviesRepository;
	
	
	
	public MoviesServiceImpl(MoviesRepository moviesRepository) {
		this.moviesRepository = moviesRepository;
	}



	@Override
	public Movies findById(Integer id) {
		// TODO Auto-generated method stub
		return moviesRepository.findById(id).get();
	}



	@Override
	public Collection<Movies> findAll() {
		// TODO Auto-generated method stub
		return moviesRepository.findAll();
	}



	@Override
	public Movies add(Movies entity) {
		// TODO Auto-generated method stub
		return moviesRepository.save(entity);
	}



	@Override
	public Movies update(Movies entity) {
		// TODO Auto-generated method stub
		return moviesRepository.save(entity);
	}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Movies entity) {
		// TODO Auto-generated method stub
		
	}


	
}