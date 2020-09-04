package com.hackmhw.pedeletra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackmhw.pedeletra.model.Crianca;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long>{

}
