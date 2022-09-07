package com.postgres.mapper;

import com.postgres.models.Characters;
import com.postgres.models.Franchise;
import com.postgres.models.Movies;
import com.postgres.models.dto.FranchiseDTO;
import com.postgres.services.characters.CharactersService;
import com.postgres.services.franchise.FranchiseService;
import com.postgres.services.movies.MoviesService;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {
	
	
	@Autowired
	protected CharactersService charactersService;
	@Autowired
	protected FranchiseService franchiseService;
	@Autowired
	protected MoviesService moviesService;
	
	@Mapping(target = "Characters", source = "characters_id")
	@Mapping(target = "Franchise", source = "franchise_id")
	@Mapping(target = "Movies", source = "movies_id")
	
	
	public abstract FranchiseDTO franchiseToFranchiseDto(Franchise franchise);
	public abstract Collection<FranchiseDTO> franchiseToFranchiseDto(Collection<Franchise> franchise);
	
	@Mapping(target = "characters", source = "characters", qualifiedByName = "charactersIdToCharacters")
	@Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseIdToFranchise")
	@Mapping(target = "movies", source = "movies", qualifiedByName = "moviesIdToMovies")
	
	public abstract Franchise franchiseDtoToFranchise(FranchiseDTO dto);
	
	@Named("charactersToIds")
	Set<Integer> map(Set<Characters> source) {
		if (source == null)
			return null;
		return source.stream()
				.map(s -> s.getCharacters_id()).collect(Collectors.toSet());
	}
	
	@Named("franchiseIdToFranchise")
	Franchise mapIdToFranchise(int id) {
		return franchiseService.findById(id);
	}
	
	@Named("moviesIdToMovies")
	Movies mapIdToMovies(int id) {
		return moviesService.findById(id);
	}
}
	

