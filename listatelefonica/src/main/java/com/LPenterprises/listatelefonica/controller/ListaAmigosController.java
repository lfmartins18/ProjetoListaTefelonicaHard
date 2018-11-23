package com.LPenterprises.listatelefonica.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LPenterprises.listatelefonica.exception.ResourceNotFoundException;
import com.LPenterprises.listatelefonica.model.ListaAmigos;
import com.LPenterprises.listatelefonica.model.Pessoa;
import com.LPenterprises.listatelefonica.repositorie.ListaAmigosRepository;

@RestController
public class ListaAmigosController {

	@Autowired
	ListaAmigosRepository amigosRepository;

	@GetMapping("/lista_amigos")
	public Page<ListaAmigos> getListaAmigos (Pageable pageable){
		return amigosRepository.findAll(pageable);
	}

	@PostMapping("/lista_amigos")
	public ListaAmigos createListaAmigos (@Valid @RequestBody ListaAmigos amigos) {
		return amigosRepository.save(amigos);
	}

	@PutMapping("/lista_amigos/{listaamigosId}")
	public ListaAmigos updateListAmigos(@PathVariable Long listaamigosId,
			@Valid @RequestBody ListaAmigos amigoRequest) {
		return amigosRepository.findById(listaamigosId)
				.map(amigoInsert -> {
					amigoInsert.setListabloqueados(amigoRequest.getListabloqueados());
					amigoInsert.setListafavoritos(amigoRequest.getListafavoritos());
					return amigosRepository.save(amigoInsert);
				}).orElseThrow(() -> new ResourceNotFoundException("Lista de amigos não encontradas: " +listaamigosId));

	}

	@PutMapping("/lista_amigos/{listaAmigosId}/addlistablock")
	public ListaAmigos addAmigosblock(@PathVariable Long listaAmigosId,
			@Valid @RequestBody Pessoa listaBlock) {
		return amigosRepository.findById(listaAmigosId)
				.map(pessoa-> {
					pessoa.addListaAmigos(listaBlock);
					return amigosRepository.save(pessoa);
				}).orElseThrow(()-> new ResourceNotFoundException("Amigo bloqueado não encortado:" + listaAmigosId) );

	}

	@PutMapping("/lista_amigos/{listaAmigosFavoId}/addlistaFavoritos")
	public ListaAmigos addAmigosFavoritos(@PathVariable Long listaAmigosFavoId,
			@Valid @RequestBody Pessoa listafavorito) {
		return amigosRepository.findById(listaAmigosFavoId)
				.map(pessoa-> {
					pessoa.addListaAmigos(listafavorito);
					return amigosRepository.save(pessoa);
				}).orElseThrow(()-> new ResourceNotFoundException("Amigo bloqueado não encortado:" + listaAmigosFavoId) );

	}

	@DeleteMapping("/lista_amigos/{listaamigosId}")
	public ResponseEntity<?> deleteListaAmigos(@PathVariable Long listaamigosId){

		return amigosRepository.findById(listaamigosId)
				.map(deleteListaAmigos -> {
					amigosRepository.delete(deleteListaAmigos);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Lista de amigos não encontrada! " +listaamigosId));
	}
}
