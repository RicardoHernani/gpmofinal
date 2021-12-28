package com.ricardochaves.form;

import java.io.Serializable;

public class ProcedimentoForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Integer premio;
	
	private Integer cirurgiaId;
	
	private Integer referenciaCodigo;
	
	public ProcedimentoForm() {
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
