package com.ricardochaves.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardochaves.domain.Procedimento;
import com.ricardochaves.form.ProcedimentoForm;
import com.ricardochaves.services.ProcedimentoService;

@RestController
@RequestMapping(value="/procedimentos")
public class ProcedimentoResource {
	
	@Autowired
	private ProcedimentoService procedimentoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Procedimento> findById(@PathVariable Integer id) {
		Procedimento obj = procedimentoService.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProcedimentoForm objForm) {
		Procedimento obj = procedimentoService.fromForm(objForm);
		obj = procedimentoService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Transactional
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)	
	public ResponseEntity<Void> update(@Valid @RequestBody ProcedimentoForm objForm, @PathVariable Integer id) {
		Procedimento obj = procedimentoService.fromFormUpdate(objForm);
		obj.setId(id);
		obj = procedimentoService.update(obj);
		return ResponseEntity.noContent().build(); 
	}
	
	
}
