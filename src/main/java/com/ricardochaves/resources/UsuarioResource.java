package com.ricardochaves.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ricardochaves.domain.Usuario;
import com.ricardochaves.dto.UsuarioDTO;
import com.ricardochaves.form.UsuarioForm;
import com.ricardochaves.repositories.UsuarioRepository;
import com.ricardochaves.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario obj = usuarioService.findById(id);
		return ResponseEntity.ok().body(obj); 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List <Usuario> list = usuarioService.findAll();
		List<UsuarioDTO> listDto = list.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@Transactional
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioForm objForm) {
		Usuario obj = usuarioService.fromForm(objForm);
		obj = usuarioService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioForm objForm, @PathVariable Integer id) {
		Usuario obj = usuarioService.fromForm(objForm);
		obj.setId(id);
		obj = usuarioService.update(obj);
		return ResponseEntity.noContent().build(); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
