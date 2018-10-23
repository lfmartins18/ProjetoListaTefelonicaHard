package com.LPenterprises.listatelefonica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private Long id;

	@Column (nullable=false, unique = true)
	private String contato;

	@Column(nullable=false)
	private Integer descricao;

	@OneToOne(
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private Endereco endereco;

	@Column(name = "listagem_amigos")
	@OneToMany
	private List<ListaAmigos> listaamigos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getDescricao() {
		return descricao;
	}

	public void setDescricao(Integer descricao) {
		this.descricao = descricao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<ListaAmigos> getListaamigos() {
		return listaamigos;
	}

	public void setListaamigos(List<ListaAmigos> listaamigos) {
		this.listaamigos = listaamigos;
	}


}
