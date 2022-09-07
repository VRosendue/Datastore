package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.models.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}
