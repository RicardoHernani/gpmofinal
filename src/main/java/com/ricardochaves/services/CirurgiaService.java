package com.ricardochaves.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.repositories.CirurgiaRepository;

@Service
public class CirurgiaService {

	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	public List<Cirurgia> buscarPorPeriodo() {
		return cirurgiaRepository.buscarPorPeriodo();
	}
	
	
}
