package com.ricardochaves.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Referencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer codigo;
	
	private String descricao;
	private Double pontos;
	private Double valor;
	
	public Referencia() {
	}

	public Referencia(Integer codigo, String descricao, Double ponto, Double valor) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.pontos = ponto;
		this.valor = valor;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPonto() {
		return pontos;
	}

	public void setPonto(Double ponto) {
		this.pontos = ponto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Referencia other = (Referencia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
