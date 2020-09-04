package com.hackmhw.pedeletra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackmhw.pedeletra.repository.CofreRepository;

@RestController
@RequestMapping("/cofre")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CofreController {
	
	@Autowired
	private CofreRepository repository;
	
	

}
