package com.postgres.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.models.Characters;
import com.postgres.models.Franchise;
import com.postgres.models.dto.FranchiseDTO;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseDTO, Integer> {
	public List<FranchiseDTO> findAll();
}
