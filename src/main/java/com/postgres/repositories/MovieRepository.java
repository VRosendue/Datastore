package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.models.Movies;
import com.postgres.models.dto.FranchiseDTO;
import com.postgres.models.dto.MovieDTO;
import com.postgres.models.dto.MoviesDTO;

public interface MovieRepository extends JpaRepository<MovieDTO, Integer> {
	public MovieDTO getMovieTitle(String movieTitle);
}
