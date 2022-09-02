package com.postgres.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.postgres.models.Characters;
import com.postgres.services.CrudService;
import com.postgres.services.characters.CharacterService;
import com.postgres.services.characters.CharacterServiceImpl;


@RestController
@RequestMapping(path = "api/v1/Characters")
public class CharactersController {

private final CharacterService characterService;


public CharactersController(CharacterService characterService) {
	this.characterService = characterService;
}

	
	
	
	@GetMapping("{id}")
	public ResponseEntity<String> path(@PathVariable int id) {
		return ResponseEntity.ok(String.valueOf(id));
	}

	@GetMapping //CRUD function getAll
	public ResponseEntity<Collection<Characters>> getAll(@RequestParam Integer Id) {
		return ResponseEntity.ok(characterService.findAll());
	}
	@GetMapping("search") // GET: localhost:8080/api/v1/students/search?name=Ola
	public ResponseEntity<Characters> findById(@PathVariable Integer Id) {
		return ResponseEntity.ok(characterService.findById(Id));
	}
	
	@PostMapping
	public ResponseEntity add(@RequestBody Characters characters) {
		Characters character = characterService.add(characters);
		URI location = URI.create("character/" + character.);
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Characters> create(@PathVariable Integer Id) {
		return ResponseEntity.ok(characterService.create(null)); //Needs to be double checked
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Characters> update(@PathVariable Integer T) {
		return ResponseEntity.ok(characterService.update(Characters));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Characters> deleteById(@PathVariable Integer T) {
		return ResponseEntity.ok(characterService.deleteById(T));
	}
}
/*
	@GetMapping("bar")
	public ResponseEntity<String> bar() {
		return ResponseEntity.ok("Bar!");
	}

	@RequestMapping(method = RequestMethod.GET, path = "baz")
	public ResponseEntity<String> baz() {
		return ResponseEntity.ok("baz!"); */






