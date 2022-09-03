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
	
	public MoviesDTO(int character_id, String fullName, int alias, int gender, Set<Integer> movies) {
		super();
		this.character_id = character_id;
		this.fullName = fullName;
		this.alias = alias;
		this.gender = gender;
		this.movies = movies;
	}

	public int getCharacter_id() {
		return character_id;
	}

	public void setCharacter_id(int character_id) {
		this.character_id = character_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAlias() {
		return alias;
	}

	public void setAlias(int alias) {
		this.alias = alias;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Set<Integer> getMovies() {
		return movies;
	}

	public void setMovies(Set<Integer> movies) {
		this.movies = movies;
	}
	
	
	
}
