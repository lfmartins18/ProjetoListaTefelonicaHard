package com.LPenterprises.listatelefonica.model;

import java.time.LocalDate;
import javax.persistence.*;


@Entity
public class Usuario{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column (nullable=false)
	private String nome;
	
	@Column (nullable=false,  unique=true)
	private String email;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private LocalDate dataNasc;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	
	
	

}
