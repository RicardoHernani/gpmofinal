package com.ricardochaves.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Usuario;
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
	
	
	
}
