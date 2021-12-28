package com.ricardochaves.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.domain.Procedimento;
import com.ricardochaves.domain.Referencia;
import com.ricardochaves.form.ProcedimentoForm;
import com.ricardochaves.repositories.CirurgiaRepository;
import com.ricardochaves.repositories.ProcedimentoRepository;
import com.ricardochaves.repositories.ReferenciaRepository;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	public Procedimento insert(Procedimento obj) {
		obj.setId(null);
		return procedimentoRepository.save(obj);
	}
	
	public Procedimento fromForm(ProcedimentoForm objForm) {
		Referencia ref = referenciaRepository.getById(objForm.getReferenciaCodigo());
		Cirurgia cir = cirurgiaRepository.getById(objForm.getCirurgiaId());
		Procedimento pro = new Procedimento(null, objForm.getTipo(), objForm.getPremio(), objForm.getReferenciaCodigo(), cir, ref);
		cir.getProcedimentos().add(pro);
		return pro;
	}
	
}
