package com.hackmhw.pedeletra.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackmhw.pedeletra.jwt.JwtUserFactory;
import com.hackmhw.pedeletra.model.Usuario;
import com.hackmhw.pedeletra.repository.UsuarioRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	    private UsuarioRepository repository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	    		Usuario user = repository.findByEmail(email).get();
	        if (user == null) {
	            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
	        } else {
	            return JwtUserFactory.create(user);
	        }
	    }
}
