package com.hackmhw.pedeletra.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column (name = "user_email")
	private String email;
	
	@NotNull
	@Size(min = 4, max = 9)
	@Column (name = "user_senha")
	private String senha;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column (name = "cria_nome")
	private String nome;
	
	@NotNull
	@Size(min = 2, max = 30)
	@Column (name = "cria_sobrenome")
	private String sobrenome;
	
	@Min (8)
	private int telefone;

	private List<Crianca> crianca;
	
	public List<Crianca> getCrianca() {
		return crianca;
	}

	public void setCrianca(List<Crianca> crianca) {
		this.crianca = crianca;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
