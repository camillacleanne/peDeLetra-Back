package com.hackmhw.pedeletra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackmhw.pedeletra.repository.ParenteRepository;

@RestController
@RequestMapping("/parente")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ParenteController {
	
	@Autowired
	private ParenteRepository repository;

}
