package com.LPenterprises.listatelefonica.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ListaAmigos {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	@Column(name = "lista_block")
	private List<Pessoa> listabloqueados;
	
	@OneToMany
	@Column(name = "lista_favorite")
	private List<Pessoa> listafavoritos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Pessoa> getListabloqueados() {
		return listabloqueados;
	}
	public void setListabloqueados(List<Pessoa> listabloqueados) {
		this.listabloqueados = listabloqueados;
	}
	public List<Pessoa> getListafavoritos() {
		return listafavoritos;
	}
	public void setListafavoritos(List<Pessoa> listafavoritos) {
		this.listafavoritos = listafavoritos;
	}
	public void addListaAmigos1(Pessoa listaBlock) {
		this.listabloqueados.add(listaBlock);
	
	}
	public void addListaAmigos(Pessoa listaFavorito) {
		this.listafavoritos.add(listaFavorito);
	
	}
	
}
