package com.postgres.controller;

import java.net.URI;
<<<<<<< Updated upstream

=======
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.postgres.mapper.CharactersMapper;
import com.postgres.models.Characters;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.services.CrudService;
import com.postgres.services.characters.CharactersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping(path = "api/v1/Characters")
public class CharactersController {

	private final CharactersService charactersService;
	private final CharactersMapper charactersMapper;

public CharactersController(CharactersService charactersService, CharactersMapper charactersMapper) {
	this.charactersService = charactersService;
	this.charactersMapper = charactersMapper;

	
}

	@Operation(summary = "findAll Characters")
	
	
	@GetMapping
	public ResponseEntity getAll() {
		Collection<CharactersDTO> chars = charactersMapper.charactersToCharactersDto(charactersService.findAll());
	return ResponseEntity.ok(chars);
	}
	
	
	@Operation(summary = "findById Characters")
	
	@GetMapping("{id}")
<<<<<<< Updated upstream
	public ResponseEntity getById(@PathVariable int id) {
		CharactersDTO chars = charactersMapper.charactersToCharactersDto(charactersService.findById(id));
		return ResponseEntity.ok(chars);
=======
	public ResponseEntity<String> path(@PathVariable int id) {
		return ResponseEntity.ok(String.valueOf(id));
	}

	@GetMapping //CRUD function getAll
	public ResponseEntity<ResponseEntity<ArrayList<CharactersDTO>>> getAll(@RequestParam Integer Id) {
		return ResponseEntity.ok(characterService.findAll());
	}
	@GetMapping("search") // GET: localhost:8080/api/v1/students/search?name=Ola
	public ResponseEntity<CharactersDTO> findById(@PathVariable(value = "Id") Integer Id) {
		return characterService.findById(Id);
>>>>>>> Stashed changes
	}
	
	
	@Operation(summary = "create in Characters")
	
	@PostMapping
	public ResponseEntity add(@RequestBody Characters characters) {
		Characters chars = charactersService.add(characters);
		URI location = URI.create("Characters/" + chars.getCharacters_id()); //getClass ser ikke rigtig ud
		return ResponseEntity.created(location).build();
	}
	
	
<<<<<<< Updated upstream
	@Operation(summary = "update Characters")
	
	@PutMapping("{id}")
	public ResponseEntity update(@RequestBody CharactersDTO charactersDTO, @PathVariable int id) {
		if(id != charactersDTO.getCharacter_id())
			return ResponseEntity.notFound().build();
		charactersService.update(
				charactersMapper.charactersDtoToCharacters(charactersDTO)
				);
		
		return ResponseEntity.noContent().build();
	}
	
	@Operation(summary = "Delete Character")
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable int id) {
		charactersService.deleteById(id);
		return ResponseEntity.noContent().build();
=======
	@GetMapping("{id}")
	public ResponseEntity<Characters> update( ,@PathVariable Integer T) {
		return ResponseEntity.ok(characterService.update(CharactersDTO));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Boolean> deleteById(@PathVariable Integer T) {
		return ResponseEntity.ok(characterService.deleteById(T));
>>>>>>> Stashed changes
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






