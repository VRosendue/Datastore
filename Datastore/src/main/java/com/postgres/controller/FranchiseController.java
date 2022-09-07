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

import com.postgres.mapper.CharactersMapper;
import com.postgres.mapper.FranchiseMapper;
import com.postgres.models.Characters;
import com.postgres.models.Franchise;
import com.postgres.models.dto.CharactersDTO;
import com.postgres.models.dto.FranchiseDTO;
import com.postgres.services.characters.CharactersService;
import com.postgres.services.franchise.FranchiseService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "api/v1/Franchise")
public class FranchiseController {

	private final FranchiseService franchiseService;
	private final FranchiseMapper franchiseMapper;

public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
	this.franchiseService = franchiseService;
	this.franchiseMapper = franchiseMapper;

	
}

	@Operation(summary = "findAll Franchise")
	
	
	@GetMapping
	public ResponseEntity getAll() {
		Collection<FranchiseDTO> fran = franchiseMapper.franchiseToFranchiseDto(franchiseService.findAll());
	return ResponseEntity.ok(fran);
	}
	
	
	@Operation(summary = "findById Franchise")
	
	@GetMapping("{id}")
	public ResponseEntity getById(@PathVariable int id) {
		FranchiseDTO fran = franchiseMapper.franchiseToFranchiseDto(franchiseService.findById(id));
		return ResponseEntity.ok(fran);
	}
	
	
	@Operation(summary = "create in Franchise")
	
	@PostMapping
	public ResponseEntity add(@RequestBody Franchise franchise) {
		Franchise frans = franchiseService.add(franchise);
		URI location = URI.create("Franchise/" + frans.getFranchise_id()); 
		return ResponseEntity.created(location).build();
	}
	
	
	@Operation(summary = "update Franchise") //Unfortunately could not get getFranchise_Id to work ( most likely lombok issues)
	
	/*@PutMapping("{id}")
	public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
		if(id != franchiseDTO.getFranchise_id())
			return ResponseEntity.notFound().build();
		franchiseService.update(
				franchiseMapper.franchiseDtoToFranchise(franchiseDTO)
				);
		
		return ResponseEntity.noContent().build();
	}
	*/
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable int id) {
		franchiseService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
/*
	@GetMapping("bar")
	public ResponseEntity<String> bar() {
		return ResponseEntity.ok("Bar!");
	}

	@RequestMapping(method = RequestMethod.GET, path = "baz")
	public ResponseEntity<String> baz() {
		return ResponseEntity.ok("baz!");
	}
	*/


