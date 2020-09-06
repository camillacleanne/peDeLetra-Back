package com.hackmhw.pedeletra.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hackmhw.pedeletra.jwt.JwtAuthenticationRequest;
import com.hackmhw.pedeletra.jwt.JwtTokenUtil;
import com.hackmhw.pedeletra.model.CurrentUser;
import com.hackmhw.pedeletra.model.Usuario;
import com.hackmhw.pedeletra.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class UsuarioController {
	
	//Usuario vamos usar um service 
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@Valid @RequestBody Usuario user){		
		Optional<Usuario> userExist = userService.findByEmail(user.getEmail());
		if (userExist.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					"Usuario ja contem na base, por favor tente outro");
		
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		userService.save(user);
		
		return user;		
	}
	
	@PostMapping("/auth")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest jwtAuthenticarion){
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtAuthenticarion.getEmail(), 
						jwtAuthenticarion.getPassword()
						)
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuthenticarion.getEmail());
		final Usuario user = userService.findByEmail(jwtAuthenticarion.getEmail()).get();
		final String token = jwtTokenUtil.generateToken(userDetails);
		user.setSenha(null);		
		
		return ResponseEntity.ok(new CurrentUser(token, user));
	}
	

}
