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

import com.hackmhw.pedeletra.model.Livro;
import com.hackmhw.pedeletra.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class LivroController {

	@Autowired
	private LivroRepository repository;
	
	@GetMapping 
	public ResponseEntity<List<Livro>> findAll() {		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Livro> findById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
				.orElse(ResponseEntity.notFound().build());
	}
		
	@PostMapping 
	public ResponseEntity<Livro> post(@Valid @RequestBody Livro livro) {
			
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(livro));
	}
	
	@PutMapping 
	public ResponseEntity<Livro> put(@Valid @RequestBody Livro livro) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(livro));
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> delete(@PathVariable long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build(); 
	}

}
