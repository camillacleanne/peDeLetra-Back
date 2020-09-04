package com.hackmhw.pedeletra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackmhw.pedeletra.model.StatusLeitura;

@Repository
public interface StatusLeituraRepository extends JpaRepository<StatusLeitura, Long>{

}
