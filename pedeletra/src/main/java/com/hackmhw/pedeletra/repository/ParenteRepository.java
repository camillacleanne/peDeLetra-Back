package com.hackmhw.pedeletra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackmhw.pedeletra.model.Parente;

@Repository
public interface ParenteRepository extends JpaRepository<Parente, Long>{

}
