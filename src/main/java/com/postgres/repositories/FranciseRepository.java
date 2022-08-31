package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.models.Franchise;

public interface FranciseRepository extends JpaRepository<Franchise, Integer> {

}
