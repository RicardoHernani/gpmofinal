package com.ricardochaves.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ricardochaves.dto.CirurgiaDTO;
import com.ricardochaves.repositories.CirurgiaRepository;

@Service
public class CirurgiaService {

	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	public Page<CirurgiaDTO> encontrarPorData(Integer idUsuario, LocalDate dataInicial, LocalDate dataFinal, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cirurgiaRepository.dateIntervalSearch(idUsuario, dataInicial, dataFinal, pageRequest);
	}
	
	
}
