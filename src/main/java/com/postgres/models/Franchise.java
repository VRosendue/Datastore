package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class Franchise {
	@Entity
	@Table(name = "Franchise")
	public class FranchiseC {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int franchise_id;
		
		@Column(name = "name", length = 50, nullable = false)
		private String name;
		
		@Column(name = "description", length = 50, nullable = false)
		private String decription;
		
		@OneToMany
		private Set<Movies> movies;
		
		
	}
}
		
		
		