package com.hackmhw.pedeletra.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackmhw.pedeletra.model.Crianca;
import com.hackmhw.pedeletra.repository.CriancaRepository;

@RestController
@RequestMapping("/crianca")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CriancaController {

	@Autowired
	private CriancaRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<Crianca>> findAll() {		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Crianca> findById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}
		
	@PostMapping 
	public ResponseEntity<Crianca> post(@Valid @RequestBody Crianca crianca) {
			
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(crianca));
	}
	
	@PutMapping 
	public ResponseEntity<Crianca> put(@Valid @RequestBody Crianca crianca) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(crianca));
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}
	

}


