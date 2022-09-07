package com.postgres.models;

import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


	@Entity
	@Getter
	@Setter
	@Table(name = "Characters")
	public class Characters {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int characters_id;
		
		@Column(name = "full_name", length = 50, nullable = false)
		private String fullName;
		
		@Column(name = "alias", length = 50, nullable = false)
		private String alias;
		
		@Column(name = "gender", length = 10, nullable = false)
		private String gender;
		
		@ManyToMany(mappedBy = "movieTitle")
		private Set<Movies> movies;
		
		/* @Column(name = "photo", lenght = 10, nullable = false) double check for the photo requirement */
		
		

	}
