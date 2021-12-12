package com.ricardochaves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ricardochaves.domain.Referencia;

@Repository
public interface ReferenciaRepository extends JpaRepository<Referencia, Integer> {

}