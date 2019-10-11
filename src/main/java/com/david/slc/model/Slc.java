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
@Table(name = "tb_slc")
public class Slc implements Serializable{
	
	private static final long serialVersionUID = 4070785806313955608L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Cascade(CascadeType.ALL)
	@OneToOne
	private Bcmsg bcmsg;
	
	@Cascade(CascadeType.ALL)
	@OneToOne
	private SisMsg sisMsg;
	
	public Slc() {}

	public Slc(Bcmsg bcmsg, SisMsg sisMsg) {
		super();
		this.bcmsg = bcmsg;
		this.sisMsg = sisMsg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bcmsg getBcmsg() {
		return bcmsg;
	}

	public void setBcmsg(Bcmsg bcmsg) {
		this.bcmsg = bcmsg;
	}

	public SisMsg getSisMsg() {
		return sisMsg;
	}

	public void setSisMsg(SisMsg sisMsg) {
		this.sisMsg = sisMsg;
	}
	
}
