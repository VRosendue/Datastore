package com.postgres.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.mapper.MoviesMapper;
import com.postgres.models.Movies;
import com.postgres.models.dto.MoviesDTO;
import com.postgres.services.movies.MoviesService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "api/v1/Movies")
public class MoviesController {


	
	
private final MoviesService moviesService;
private final MoviesMapper moviesMapper;

public MoviesController(MoviesService moviesService, MoviesMapper moviesMapper) {
this.moviesService = moviesService;
this.moviesMapper = moviesMapper;


}

@Operation(summary = "findAll Characters")


@GetMapping
public ResponseEntity getAll() {
	Collection<MoviesDTO> movi = moviesMapper.moviesToMoviesDto(moviesService.findAll());
return ResponseEntity.ok(movi);
}


@Operation(summary = "findById Characters")

@GetMapping("{id}")
public ResponseEntity getById(@PathVariable int id) {
	MoviesDTO movi = moviesMapper.moviesToMoviesDto(moviesService.findById(id));
	return ResponseEntity.ok(movi);
}


@Operation(summary = "create in Characters")

@PostMapping
public ResponseEntity add(@RequestBody Movies movies) {
	Movies movi = moviesService.add(movies);
	URI location = URI.create("Characters/" + movi.getMovies_id()); //getClass ser ikke rigtig ud
	return ResponseEntity.created(location).build();
}


@Operation(summary = "update Characters")

@PutMapping("{id}")
public ResponseEntity update(@RequestBody MoviesDTO moviesDTO, @PathVariable int id) {
	if(id != moviesDTO.getMovie_id())
		return ResponseEntity.notFound().build();
	moviesService.update(
			moviesMapper.moviesDtoToMovies(moviesDTO)
			);
	
	return ResponseEntity.noContent().build();
}

@DeleteMapping("{id}")
public ResponseEntity delete(@PathVariable int id) {
	moviesService.deleteById(id);
	return ResponseEntity.noContent().build();
}
}
