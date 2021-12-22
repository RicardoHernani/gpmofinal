package com.ricardochaves.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.dto.CirurgiaDTO;

@Repository
public interface CirurgiaRepository extends JpaRepository<Cirurgia, Integer>{
	
	@Query("select distinct c from Cirurgia c where usuario_id= :idUsuario and c.data>= :dataInicial and c.data<= :dataFinal")
	Page<CirurgiaDTO> dateIntervalSearch(@Param("idUsuario") Integer idUsuario, @Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal, Pageable pageRequest);
	
}
