package com.david.slc.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_grupo_sequencia")
public class GrupoSequencia implements Serializable {
	
	private static final long serialVersionUID = 8288384682148678156L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long numeroSequencia;
	
	private String indicadorContinuacao;
	
	public GrupoSequencia() {}

	public GrupoSequencia(Long numeroSequencia, String indicadorContinuacao) {
		super();
		this.numeroSequencia = numeroSequencia;
		this.indicadorContinuacao = indicadorContinuacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroSequencia() {
		return numeroSequencia;
	}

	public void setNumeroSequencia(Long numeroSequencia) {
		this.numeroSequencia = numeroSequencia;
	}

	public String getIndicadorContinuacao() {
		return indicadorContinuacao;
	}

	public void setIndicadorContinuacao(String indicadorContinuacao) {
		this.indicadorContinuacao = indicadorContinuacao;
	}
	
	
}
