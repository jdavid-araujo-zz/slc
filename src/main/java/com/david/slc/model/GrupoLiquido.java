package com.david.slc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_grupo_liquido")
public class GrupoLiquido implements Serializable {

	private static final long serialVersionUID = 3147660627278885562L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date dataLiquido;
	
	private Long numeroSequencia;
	
	@Cascade(CascadeType.ALL)
	@OneToMany
	private List<GrupoProduto> grupoProduto;
	
	public GrupoLiquido() {}	
		
	public GrupoLiquido(Date dataLiquido, Long numeroSequencia) {
		super();
		this.dataLiquido = dataLiquido;
		this.numeroSequencia = numeroSequencia;
	}


	public void setGrupoProduto(List<GrupoProduto> grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataLiquido() {
		return dataLiquido;
	}

	public void setDataLiquido(Date dataLiquido) {
		this.dataLiquido = dataLiquido;
	}

	public Long getNumeroSequencia() {
		return numeroSequencia;
	}

	public void setNumeroSequencia(Long numeroSequencia) {
		this.numeroSequencia = numeroSequencia;
	}

	public List<GrupoProduto> getGrupoProduto() {
		return grupoProduto;
	}

	public void setGurpoProduto(List<GrupoProduto> grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

}
