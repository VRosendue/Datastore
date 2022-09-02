package com.postgres.models.dto;

import java.util.Set;

import lombok.Data;

@Data
public class MoviesDTO {

	private int character_id;
	private String fullName;
	private int alias;
	private int gender;
	private Set<Integer> movies;
	
}
