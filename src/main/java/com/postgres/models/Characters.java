package com.postgres.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Characters")
public class Characters {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int character_id;

	@Column(name = "full_name", length = 50, nullable = false)
	private String fullName;

	@Column(name = "alias", length = 50, nullable = false)
	private String alias;

	@Column(name = "gender", length = 10, nullable = false)
	private String gender;

	@ManyToMany
	private Set<Movies> movies;

	/*
	 * @Column(name = "photo", lenght = 10, nullable = false) double check for the
	 * photo requirement
	 */

}
