package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.models.Characters;

public interface CharactersRepository extends JpaRepository<Characters, Integer> {

}
