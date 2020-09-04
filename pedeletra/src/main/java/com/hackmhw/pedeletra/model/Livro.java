package com.hackmhw.pedeletra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 8000)
	private String link;

	@NotNull
	@Size(min = 1, max = 8000)
	private String titulo;

	@Min(1)
	private int qtdPag;
	
	private int minLeitura;
	
	@Min(1)
	private int varMoeda;
	
	private int faixaEtaria;

	private List<StatusLeitura> statusleitura;

	public List<StatusLeitura> getStatusleitura() {
		return statusleitura;
	}

	public void setStatusleitura(List<StatusLeitura> statusleitura) {
		this.statusleitura = statusleitura;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getQtdPag() {
		return qtdPag;
	}

	public void setQtdPag(int qtdPag) {
		this.qtdPag = qtdPag;
	}

	public int getMinLeitura() {
		return minLeitura;
	}

	public void setMinLeitura(int minLeitura) {
		this.minLeitura = minLeitura;
	}

	public int getVarMoeda() {
		return varMoeda;
	}

	public void setVarMoeda(int varMoeda) {
		this.varMoeda = varMoeda;
	}

	public int getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

}
