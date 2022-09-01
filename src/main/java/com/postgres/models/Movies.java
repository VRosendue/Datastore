package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movie_id;

	@Column(name = "movie_title", length = 50, nullable = false)
	private String movieTitle;

	@Column(name = "genre", length = 10, nullable = false)
	private String[] genre = { "Action", "Comedy", "Drama", "Fantasy", "Horror", "Mystery", "Romance", "Thriller" };

	@Column(name = "Release_year", length = 4, nullable = false)
	private int releaseYear;

	@Column(name = "director", length = 10, nullable = false)
	private String director;

	@Column(name = "picture", columnDefinition = "NVARCHAR(MAX)", nullable = false)
	private String picture; // Same applies here, gonna need to figure out the URL stuff

	@Column(name = "trailer", length = 70, nullable = false)
	private String trailer;

	@ManyToMany
	private Set<Characters> characters;

	@OneToOne
	private Set<Franchise> franchise;
}

/*
 * @Column(name = "photo", lenght = 10, nullable = false) double check for the
 * photo requirement
 */
