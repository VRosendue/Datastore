package com.postgres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgres.models.Characters;
import com.postgres.models.dto.CharactersDTO;

public interface CharactersRepository extends JpaRepository<CharactersDTO, Integer> {

	public CharactersDTO getCharacterFullName(String fullName);
}
