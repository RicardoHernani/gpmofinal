package com.ricardochaves.form;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CirurgiaForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer matricula;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private Integer usuarioId;
	
	public CirurgiaForm() {
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


}
