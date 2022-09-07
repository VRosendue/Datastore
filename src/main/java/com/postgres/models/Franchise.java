package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


	@Entity
	@Getter
	@Setter
	@Table(name = "Franchise")
	public class Franchise {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int franchise_id;
		
		@Column(name = "name", length = 50, nullable = false)
		private String name;
		
		@Column(name = "description", length = 50, nullable = false)
		private String decription;
		
		
		@OneToMany
		private Set<Movies> movies;
		

		
	}

		
		
		