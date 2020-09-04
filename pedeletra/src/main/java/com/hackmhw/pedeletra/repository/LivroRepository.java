package com.hackmhw.pedeletra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackmhw.pedeletra.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
