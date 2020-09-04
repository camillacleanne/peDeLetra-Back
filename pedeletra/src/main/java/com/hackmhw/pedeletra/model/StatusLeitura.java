package com.hackmhw.pedeletra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status_leitura")
public class StatusLeitura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Livro livro;
	
	private boolean leu;
	
	private Crianca crianca;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public boolean isLeu() {
		return leu;
	}

	public void setLeu(boolean leu) {
		this.leu = leu;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}
	
	
}
