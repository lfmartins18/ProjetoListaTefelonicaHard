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
	private List<ListaBlock> listabloqueados;
	
	@OneToMany
	@Column(name = "lista_favorite")
	private List<ListaFavoritos> listafavoritos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ListaBlock> getListabloqueados() {
		return listabloqueados;
	}

	public void setListabloqueados(List<ListaBlock> listabloqueados) {
		this.listabloqueados = listabloqueados;
	}

	public List<ListaFavoritos> getListafavoritos() {
		return listafavoritos;
	}

	public void setListafavoritos(List<ListaFavoritos> listafavoritos) {
		this.listafavoritos = listafavoritos;
	}
	
	public void addListaAmigos(ListaBlock listaBlock) {
		this.listabloqueados.add(listaBlock);
	
	}
	public void addListaAmigos(ListaFavoritos listaFavorito) {
		this.listafavoritos.add(listaFavorito);
	
	}
	
}
