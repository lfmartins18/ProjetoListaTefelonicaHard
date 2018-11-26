package com.LPenterprises.listatelefonica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Regiao {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
    private String nacionalidade;
	
	@Column(nullable=false)
	private String estado;
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String cep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
    
    
     
}
