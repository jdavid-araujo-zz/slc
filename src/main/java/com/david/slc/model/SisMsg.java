package com.david.slc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_sis_msg")
public class SisMsg implements Serializable{
	
	private static final long serialVersionUID = 150545049830649625L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String codigoMessagem;
	
	private String numeroControle;
	
	private String ispbif;
	
	private String tping;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtHrSlc;
	
	@Temporal(TemporalType.DATE)
	private Date dtMovto;
	
	@Cascade(CascadeType.ALL)
	@OneToOne
	private GrupoLiquido grupoLiquido;
	
	public SisMsg() {}
	

	public SisMsg(String codigoMessagem, String numeroControle, String ispbif, String tping, Date dtHrSlc,
			Date dtMovto) {
		this.codigoMessagem = codigoMessagem;
		this.numeroControle = numeroControle;
		this.ispbif = ispbif;
		this.tping = tping;
		this.dtHrSlc = dtHrSlc;
		this.dtMovto = dtMovto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoMessagem() {
		return codigoMessagem;
	}

	public void setCodigoMessagem(String codigoMessagem) {
		this.codigoMessagem = codigoMessagem;
	}

	public String getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(String numeroControle) {
		this.numeroControle = numeroControle;
	}

	public String getIspbif() {
		return ispbif;
	}

	public void setIspbif(String ispbif) {
		this.ispbif = ispbif;
	}

	public String getTping() {
		return tping;
	}

	public void setTping(String tping) {
		this.tping = tping;
	}

	public GrupoLiquido getGrupoLiquido() {
		return grupoLiquido;
	}

	public void setGrupoLiquido(GrupoLiquido grupoLiquido) {
		this.grupoLiquido = grupoLiquido;
	}

	public Date getDtHrSlc() {
		return dtHrSlc;
	}

	public void setDtHrSlc(Date dtHrSlc) {
		this.dtHrSlc = dtHrSlc;
	}

	public Date getDtMovto() {
		return dtMovto;
	}

	public void setDtMovto(Date dtMovto) {
		this.dtMovto = dtMovto;
	}	
	
}
