package com.postgres.models.dto;

import java.util.Set;

import com.postgres.models.Characters;
import com.postgres.models.Franchise;

import lombok.Data;

@Data
public class MoviesDTO {

	private int movie_id;
	private String movieTitle;
	private String[] genre;
	private int releaseYear;
	private String director;
	private String picture;
	private String trailer;
	private Set<Characters> characters;
	private Set<Franchise> franchise;
	
	

}