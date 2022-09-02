package com.postgres.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.models.Movies.MovieC;

@RestController
@RequestMapping(path = "api/v1/test")
public class MoviesController {

private final MoviesMapper;
	
	
	
	@GetMapping("{id}")
	public ResponseEntity<String> path(@PathVariable int id) {
		return ResponseEntity.ok(String.valueOf(id));
	}

	@GetMapping //CRUD function getAll
	public ResponseEntity<Collection<MovieC>> getAll() {
		return ResponseEntity.ok(characterService.findAll());
	}
	@GetMapping("search") // GET: localhost:8080/api/v1/students/search?name=Ola
	public ResponseEntity<Collection<MovieC>> findByName(@RequestParam String name) {
		return ResponseEntity.ok(moviesService.findAllByName(name));
	}

	@GetMapping("bar")
	public ResponseEntity<String> bar() {
		return ResponseEntity.ok("Bar!");
	}

	@RequestMapping(method = RequestMethod.GET, path = "baz")
	public ResponseEntity<String> baz() {
		return ResponseEntity.ok("baz!");
	}

}
