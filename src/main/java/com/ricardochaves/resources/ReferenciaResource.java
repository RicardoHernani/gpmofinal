package com.ricardochaves.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ricardochaves.domain.Referencia;
import com.ricardochaves.services.ReferenciaService;

@RestController
@RequestMapping(value="/referencias")
public class ReferenciaResource {
	
	@Autowired
	private ReferenciaService referenciaService;

	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<Referencia> findById(@PathVariable Integer codigo) {
		Referencia obj = referenciaService.findById(codigo);
		return ResponseEntity.ok().body(obj); 
	}
	
	
	
}
