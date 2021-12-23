package com.ricardochaves.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ricardochaves.domain.Referencia;
import com.ricardochaves.repositories.ReferenciaRepository;
import com.ricardochaves.services.exceptions.ObjectNotFoundException;

@Service
public class ReferenciaService {
	
	@Autowired
	private ReferenciaRepository referenciaRepository;

	public Referencia findById(Integer codigo) {
		Optional<Referencia> obj = referenciaRepository.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Código não encontrado! código: " + codigo
				+ ", Tipo: " + Referencia.class.getName()));
	}
	
	
}
