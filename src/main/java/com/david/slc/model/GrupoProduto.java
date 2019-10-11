package com.david.slc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_grupo_produto")
public class GrupoProduto implements Serializable {

	private static final long serialVersionUID = -5775286345479373278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigoProduto;
	
	@Cascade(CascadeType.ALL)
	@OneToMany
	private List<GrupoLiquidoProduto> grupoLiquidoProduto;
	
	public GrupoProduto() {}
	
	public GrupoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public List<GrupoLiquidoProduto> getGrupoLiquidoProduto() {
		return grupoLiquidoProduto;
	}

	public void setGrupoLiquidoProduto(List<GrupoLiquidoProduto> grupoLiquidoProduto) {
		this.grupoLiquidoProduto = grupoLiquidoProduto;
	}

	@Override
	public String toString() {
		return "GrupoProduto [codigoProduto=" + codigoProduto + ", grupoLiquidoProduto=" + grupoLiquidoProduto + "]";
	}
	
	
	
}
