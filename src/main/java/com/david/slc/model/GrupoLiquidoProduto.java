package com.david.slc.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_grupo_liquido_produto")
public class GrupoLiquidoProduto implements Serializable {
	
	private static final long serialVersionUID = 1631992639052176884L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String identidade;
	
	private String tpDebCred;
	
	private String credtd;
	
	private String debtd;
	
	private BigDecimal vlr;
	
	private String cnpjDebtd;
	
	private String clienteDebtd;
	
	private String cnpjCredtd;
	
	private String clienteCredtd;
	
	private Long slc;
	
	public GrupoLiquidoProduto() {}

	public GrupoLiquidoProduto(String identidade, String tpDebCred, String credtd, String debtd, BigDecimal vlr,
			String cnpjDebtd, String clienteDebtd, String cnpjCredtd, String clienteCredtd, Long slc) {
		this.identidade = identidade;
		this.tpDebCred = tpDebCred;
		this.credtd = credtd;
		this.debtd = debtd;
		this.vlr = vlr;
		this.cnpjDebtd = cnpjDebtd;
		this.clienteDebtd = clienteDebtd;
		this.cnpjCredtd = cnpjCredtd;
		this.clienteCredtd = clienteCredtd;
		this.slc = slc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getTpDebCred() {
		return tpDebCred;
	}

	public void setTpDebCred(String tpDebCred) {
		this.tpDebCred = tpDebCred;
	}

	public String getCredtd() {
		return credtd;
	}

	public void setCredtd(String credtd) {
		this.credtd = credtd;
	}

	public String getDebtd() {
		return debtd;
	}

	public void setDebtd(String debtd) {
		this.debtd = debtd;
	}

	public BigDecimal getVlr() {
		return vlr;
	}

	public void setVlr(BigDecimal vlr) {
		this.vlr = vlr;
	}

	public String getCnpjDebtd() {
		return cnpjDebtd;
	}

	public void setCnpjDebtd(String cnpjDebtd) {
		this.cnpjDebtd = cnpjDebtd;
	}

	public String getClienteDebtd() {
		return clienteDebtd;
	}

	public void setClienteDebtd(String clienteDebtd) {
		this.clienteDebtd = clienteDebtd;
	}

	public String getCnpjCredtd() {
		return cnpjCredtd;
	}

	public void setCnpjCredtd(String cnpjCredtd) {
		this.cnpjCredtd = cnpjCredtd;
	}

	public String getClienteCredtd() {
		return clienteCredtd;
	}

	public void setClienteCredtd(String clienteCredtd) {
		this.clienteCredtd = clienteCredtd;
	}

	public Long getSlc() {
		return slc;
	}

	public void setSlc(Long slc) {
		this.slc = slc;
	}

	@Override
	public String toString() {
		return "GrupoLiquidoProduto [identidade=" + identidade + ", tpDebCred=" + tpDebCred + ", credtd=" + credtd
				+ ", debtd=" + debtd + ", vlr=" + vlr + ", cnpjDebtd=" + cnpjDebtd + ", clienteDebtd=" + clienteDebtd
				+ ", cnpjCredtd=" + cnpjCredtd + ", clienteCredtd=" + clienteCredtd + ", slc=" + slc + "]";
	}

	
}
