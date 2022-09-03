package com.postgres.models.dto;

import java.util.Set;

import lombok.Data;

@Data
public class FranchiseDTO {
	
	private int franchise_id;
	private String name;
	private String description;
	private Set<Integer> movies;
	
	public FranchiseDTO(int franchise_id, String name, String description, Set<Integer> movies) {
		super();
		this.franchise_id = franchise_id;
		this.name = name;
		this.description = description;
		this.movies = movies;
	}
	public int getFranchise_id() {
		return franchise_id;
	}
	public void setFranchise_id(int franchise_id) {
		this.franchise_id = franchise_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Integer> getMovies() {
		return movies;
	}
	public void setMovies(Set<Integer> movies) {
		this.movies = movies;
	}

	
}
