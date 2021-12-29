package com.ricardochaves.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ricardochaves.domain.Cirurgia;
import com.ricardochaves.domain.Usuario;
import com.ricardochaves.dto.CirurgiaDTO;
import com.ricardochaves.form.CirurgiaForm;
import com.ricardochaves.repositories.CirurgiaRepository;
import com.ricardochaves.repositories.UsuarioRepository;
import com.ricardochaves.services.exceptions.ObjectNotFoundException;

@Service
public class CirurgiaService {

	@Autowired
	private CirurgiaRepository cirurgiaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Cirurgia findById(Integer id) {
		Optional<Cirurgia> obj = cirurgiaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cirurgia não encontrada! id: " + id
				+ ", Tipo: " + Cirurgia.class.getName()));
	}
	
	public Page<CirurgiaDTO> encontrarPorData(Integer idUsuario, LocalDate dataInicial, LocalDate dataFinal, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cirurgiaRepository.dateIntervalSearch(idUsuario, dataInicial, dataFinal, pageRequest);
	}
	
	public Cirurgia insert(Cirurgia obj) {
		obj.setId(null);
		return cirurgiaRepository.save(obj);
	}
	
	public Cirurgia fromForm(CirurgiaForm objForm) {
		Usuario usu = usuarioRepository.getById(objForm.getUsuarioId());
		Cirurgia cir = new Cirurgia(null, objForm.getMatricula(), objForm.getData(), usu);
		return cir;
	}
	
}
