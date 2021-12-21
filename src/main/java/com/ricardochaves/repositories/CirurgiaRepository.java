package com.ricardochaves.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ricardochaves.domain.Cirurgia;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer>{

	@Query("select distinct c from Cirurgia c where usuario_id=3 and c.data>= '2000-02-07' and c.data<= '2010-12-24'")
	List<Cirurgia> buscarPorPeriodo();
	
	@Query("select distinct c from Cirurgia c where usuario_id= :idUsuario and c.data>= :dataInicial and c.data<= :dataFinal")
	Page<Cirurgia> dateIntervalSearch(@Param("idUsuario") Integer idUsuario, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal, Pageable pageRequest);
	
}
