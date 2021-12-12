package com.ricardochaves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ricardochaves.domain.Cirurgia;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer>{

}
