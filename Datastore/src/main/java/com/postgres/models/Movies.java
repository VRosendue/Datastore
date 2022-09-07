package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



	@Entity
	@Getter
	@Setter
	@Table(name = "Movies")
	public class Movies {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int movies_id;
		
		@Column(name = "movie_title", length = 50, nullable = false)
		private String movieTitle;
		
		@Column(name = "genre", columnDefinition = "varchar(255)" , nullable = false)
		private String[] genre = {"Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery", "Romance", "Thriller"};
		
		@Column(name = "Release_year", length = 4, nullable = false)
		private int releaseYear;
		
		@Column(name = "director", length = 10, nullable = false)
		private String director;
		
		@Column (name = "picture", length = 1000 , nullable = false)
		private String picture; //Same applies here, gonna need to figure out the URL stuff
		
		@Column (name = "trailer", length = 70, nullable = false)
		private String trailer;
		
		@ManyToMany
		@JoinColumn(name = "full_name")
		private Set<Characters> characters;
		
		@ManyToOne
		@JoinColumn(name = "franchise_id")
		private Franchise franchise;
		
	}

		
		/* @Column(name = "photo", lenght = 10, nullable = false) double check for the photo requirement */
		
		