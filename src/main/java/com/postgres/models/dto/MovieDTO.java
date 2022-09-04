package com.postgres.models.dto;

import java.util.Set;

import com.postgres.models.Characters;
import com.postgres.models.Franchise;

import lombok.Data;

@Data
public class MovieDTO {

	private int movie_id;
	private String movieTitle;
	private String[] genre;
	private int releaseYear;
	private String director;
	private String picture;
	private String trailer;
	private Set<Characters> characters;
	private Set<Franchise> franchise;
	
	public MovieDTO(int movie_id, String movieTitle, String[] genre, int releaseYear, String director, String picture,
			String trailer, Set<Characters> characters, Set<Franchise> franchise) {
		super();
		this.movie_id = movie_id;
		this.movieTitle = movieTitle;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.director = director;
		this.picture = picture;
		this.trailer = trailer;
		this.characters = characters;
		this.franchise = franchise;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String[] getGenre() {
		return genre;
	}

	public void setGenre(String[] genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Set<Characters> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Characters> characters) {
		this.characters = characters;
	}

	public Set<Franchise> getFranchise() {
		return franchise;
	}

	public void setFranchise(Set<Franchise> franchise) {
		this.franchise = franchise;
	}
	


}
