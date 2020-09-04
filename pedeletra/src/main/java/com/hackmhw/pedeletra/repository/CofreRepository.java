package com.hackmhw.pedeletra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackmhw.pedeletra.model.Cofre;

@Repository
public interface CofreRepository extends JpaRepository<Cofre, Long>{

}
