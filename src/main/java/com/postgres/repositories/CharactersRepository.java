package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgres.models.Characters;

@Repository
public interface CharactersRepository extends JpaRepository<Characters, Integer> {

}
