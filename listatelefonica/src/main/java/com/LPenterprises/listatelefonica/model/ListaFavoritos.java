package com.LPenterprises.listatelefonica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListaFavoritos {

	@Id
	@GeneratedValue
	private Integer id;

	private String motivoFavorito;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMotivoFavorito() {
		return motivoFavorito;
	}

	public void setMotivoFavorito(String motivoFavorito) {
		this.motivoFavorito = motivoFavorito;
	}




}
