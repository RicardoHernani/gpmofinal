package com.ricardochaves.form;

import java.io.Serializable;

import com.ricardochaves.domain.Procedimento;

public class ProcedimentoForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Integer premio;
	
	private Integer cirurgiaId;
	
	private Integer referenciaCodigo;
	
	public ProcedimentoForm() {
	}

	public ProcedimentoForm(Procedimento obj) {
		super();
		this.tipo = obj.getTipo();
		this.premio = obj.getPremio();
		this.cirurgiaId = obj.getCirurgia().getId();
		this.referenciaCodigo = obj.getReferencia().getCodigo();
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getPremio() {
		return premio;
	}

	public void setPremio(Integer premio) {
		this.premio = premio;
	}

	public Integer getCirurgiaId() {
		return cirurgiaId;
	}

	public void setCirurgiaId(Integer cirurgiaId) {
		this.cirurgiaId = cirurgiaId;
	}

	public Integer getReferenciaCodigo() {
		return referenciaCodigo;
	}

	public void setReferenciaCodigo(Integer referenciaCodigo) {
		this.referenciaCodigo = referenciaCodigo;
	}
	
}
