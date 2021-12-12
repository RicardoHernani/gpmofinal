package com.ricardochaves.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.services.CirurgiaService;

@RestController
@RequestMapping(value="/cirurgias")
public class CirurgiaResource {

	@Autowired
	private CirurgiaService cirurgiaService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cirurgia>> buscarPorPeriodo() {
		List<Cirurgia> list = cirurgiaService.buscarPorPeriodo();
		return ResponseEntity.ok().body(list);
	}
}