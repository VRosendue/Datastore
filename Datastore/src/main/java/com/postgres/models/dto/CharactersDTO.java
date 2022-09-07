package com.postgres.models.dto;

import java.util.Set;

import com.postgres.models.Franchise;
import com.postgres.models.Movies;

import lombok.Data;

@Data

public class CharactersDTO {

	private int character_id;
	private String fullName;
	private String alias;
	private String gender;
	private Set<Movies> movies;
	private Set<Franchise> franchise;
	
	
}