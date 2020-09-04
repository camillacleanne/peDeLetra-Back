package com.hackmhw.pedeletra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "tb_cofre")
public class Cofre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Crianca crianca;

	@Min(1)
	private int cofreQtd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public int getCofreQtd() {
		return cofreQtd;
	}

	public void setCofreQtd(int cofreQtd) {
		this.cofreQtd = cofreQtd;
	}

}
