package com.ricardochaves.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Usuario;
import com.ricardochaves.form.UsuarioForm;
import com.ricardochaves.repositories.UsuarioRepository;
import com.ricardochaves.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! id: " + id
				+ ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		findById(obj.getId());
		return usuarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		usuarioRepository.deleteById(id);
	}
	
	public Usuario fromForm(UsuarioForm objForm) {
		return new Usuario(objForm.getId(), objForm.getNome(), objForm.getEmail(), objForm.getSenha());
	}
	
}
