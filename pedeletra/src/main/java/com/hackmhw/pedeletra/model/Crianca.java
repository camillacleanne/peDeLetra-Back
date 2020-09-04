package com.hackmhw.pedeletra.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_crianca")
public class Crianca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column (name = "cria_nome")
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column (name = "cria_nick")
	private String nick;
	
	@ManyToOne
	private Parente parente;
	
	@Min (1)
	private int idade;
	
	@ManyToOne
	@JsonIgnoreProperties("crianca") // Para evitar recursividade Infinita por que crianca tem usuario e usuario tem uma lista de crianca
	private Usuario usuario;
	
	@OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL) //mapeando o objeto em leitura.
	@JsonIgnoreProperties("crianca") //Assim como a linha 45 estamos evitadon recursividade
	private List<StatusLeitura> leitura;
	
	public List<StatusLeitura> getLeitura() {
		return leitura;
	}

	public void setLeitura(List<StatusLeitura> leitura) {
		this.leitura = leitura;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Parente getParente() {
		return parente;
	}

	public void setParente(Parente parente) {
		this.parente = parente;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
