package com.ricardochaves.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.domain.Procedimento;
import com.ricardochaves.domain.Referencia;
import com.ricardochaves.form.ProcedimentoForm;
import com.ricardochaves.form.ProcedimentoFormUpdate;
import com.ricardochaves.repositories.CirurgiaRepository;
import com.ricardochaves.repositories.ProcedimentoRepository;
import com.ricardochaves.repositories.ReferenciaRepository;
import com.ricardochaves.services.exceptions.ObjectNotFoundException;

@Service
public class ProcedimentoService {

	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	
	@Autowired
	private ReferenciaRepository referenciaRepository;
	
	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	public Procedimento findById(Integer id) {
		Optional<Procedimento> obj = procedimentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Procedimento não encontrado! id: " + id
				+ ", Tipo: " + Procedimento.class.getName()));
	}
	
	public Procedimento insert(Procedimento obj) {
		obj.setId(null);
		return procedimentoRepository.save(obj);
	}
	
	public Procedimento fromForm(ProcedimentoForm objForm) {
		Referencia ref = referenciaRepository.getById(objForm.getReferenciaCodigo());
		Cirurgia cir = cirurgiaRepository.getById(objForm.getCirurgiaId());
		Procedimento pro = new Procedimento(null, objForm.getTipo(), objForm.getPremio(), cir, ref);
		cir.getProcedimentos().add(pro);
		return pro;
	}
	
	public Procedimento update(Procedimento obj) {
		Procedimento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return procedimentoRepository.save(newObj);
	}
	
	public Procedimento fromFormUpdate(ProcedimentoFormUpdate objForm) {						 				 
		Referencia ref = referenciaRepository.getById(objForm.getReferenciaCodigo());
		ref.getCodigo();
		return new Procedimento(null, objForm.getTipo(), objForm.getPremio(), null, ref);	   
	}
	
	private void updateData(Procedimento newObj, Procedimento obj) {
		newObj.setTipo(obj.getTipo());
		newObj.setPremio(obj.getPremio());
		newObj.setReferencia(obj.getReferencia());

	}
	
}
