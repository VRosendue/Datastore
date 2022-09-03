package com.postgres.models.dto;

import java.util.Set;

import com.postgres.models.Franchise;

import lombok.Data;

@Data
public class CharactersDTO {

	private int character_id;
	private String fullName;
	private String alias;
	private String gender;
	private Set<Integer> movies;
	private Set<Franchise> franchise;
	
	
	public CharactersDTO(int character_id, String fullName, String alias, String gender, Set<Integer> movies,
			Set<Franchise> franchise) {
		super();
		this.character_id = character_id;
		this.fullName = fullName;
		this.alias = alias;
		this.gender = gender;
		this.movies = movies;
		this.franchise = franchise;
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


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Set<Integer> getMovies() {
		return movies;
	}


	public void setMovies(Set<Integer> movies) {
		this.movies = movies;
	}


	public Set<Franchise> getFranchise() {
		return franchise;
	}


	public void setFranchise(Set<Franchise> franchise) {
		this.franchise = franchise;
	}
}