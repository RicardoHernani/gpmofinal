package com.ricardochaves.form;

import java.io.Serializable;

public class ProcedimentoFormUpdate implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tipo;
	private Integer premio;
	
	private Integer referenciaCodigo;
	
	public ProcedimentoFormUpdate() {
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

	public Integer getReferenciaCodigo() {
		return referenciaCodigo;
	}

	public void setReferenciaCodigo(Integer referenciaCodigo) {
		this.referenciaCodigo = referenciaCodigo;
	}
		
}
