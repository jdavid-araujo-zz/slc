package com.david.slc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_bcmsg")
public class Bcmsg implements Serializable{
	
	private static final long serialVersionUID = 7378077554088481299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long emmissor;
	
	private Long destinatario;
	
	@Cascade(CascadeType.ALL)
	@OneToOne
	private GrupoSequencia grupoSequencia;
	
	private String dominioSistema;
	
	private String numeroOperacao;
	
	public Bcmsg() {}

	public Bcmsg(Long emmissor, Long destinatario, GrupoSequencia grupoSequencia, String dominioSistema,
			String numeroOperacao) {
		super();
		this.emmissor = emmissor;
		this.destinatario = destinatario;
		this.grupoSequencia = grupoSequencia;
		this.dominioSistema = dominioSistema;
		this.numeroOperacao = numeroOperacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmmissor() {
		return emmissor;
	}

	public void setEmmissor(Long emmissor) {
		this.emmissor = emmissor;
	}

	public Long getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Long destinatario) {
		this.destinatario = destinatario;
	}

	public GrupoSequencia getGrupoSequencia() {
		return grupoSequencia;
	}

	public void setGrupoSequencia(GrupoSequencia grupoSequencia) {
		this.grupoSequencia = grupoSequencia;
	}

	public String getDominioSistema() {
		return dominioSistema;
	}

	public void setDominioSistema(String dominioSistema) {
		this.dominioSistema = dominioSistema;
	}

	public String getNumeroOperacao() {
		return numeroOperacao;
	}

	public void setNumeroOperacao(String numeroOperacao) {
		this.numeroOperacao = numeroOperacao;
	}
	
	
}
