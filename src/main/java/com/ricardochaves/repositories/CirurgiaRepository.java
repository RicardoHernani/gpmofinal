package com.ricardochaves.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ricardochaves.domain.Cirurgia;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer>{

	@Query("select distinct c from Cirurgia c where usuario_id=1 and c.data>= '2020-02-07' and c.data<= '2020-12-24'")
	List<Cirurgia> buscarPorPeriodo();
	
}
