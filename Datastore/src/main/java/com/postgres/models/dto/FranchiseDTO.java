package com.postgres.models.dto;

import java.util.Set;

import lombok.Data;

@Data
public class FranchiseDTO {
	
	private int franchise_id;
	private String name;
	private String description;
	private Set<Integer> movies;

}
