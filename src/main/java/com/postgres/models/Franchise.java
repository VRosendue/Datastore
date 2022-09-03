package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Franchise")
public class Franchise {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int franchise_id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "description", length = 50, nullable = false)
	private String decription;

	@OneToMany
	private Set<Movies> movies;

	public Franchise(int franchise_id, String name, String decription, Set<Movies> movies) {
		super();
		this.franchise_id = franchise_id;
		this.name = name;
		this.decription = decription;
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

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	public Set<Movies> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	

}
