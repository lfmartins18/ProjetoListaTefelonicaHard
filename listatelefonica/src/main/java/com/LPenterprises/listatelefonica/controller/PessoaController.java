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
import com.LPenterprises.listatelefonica.model.ListaFavoritos;
import com.LPenterprises.listatelefonica.model.Pessoa;
import com.LPenterprises.listatelefonica.repositorie.PessoaRepository;

@RestController
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/pessoa")
	public Page<Pessoa> getPessoas (Pageable pageable){
		return pessoaRepository.findAll(pageable);
	}

	@GetMapping("/pessoa/{pessoaId}")
	public Pessoa getPessoa(@PathVariable Long pessoaId) {
		return pessoaRepository.findById(pessoaId)
				.orElseThrow(() -> new ResourceNotFoundException("Erro!!" +pessoaId));
	}

	@PostMapping("/pessoa")
	public Pessoa createPessoa (@Valid @RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);	
	}

	@PutMapping("/pessoa/{pessoaId}")
	public Pessoa updatePessoa(@PathVariable Long pessoaId,
			@Valid @RequestBody Pessoa pessoaRequest) {
		return pessoaRepository.findById(pessoaId)
				.map(pessoaInsert -> {
					pessoaInsert.setContato(pessoaRequest.getContato());
					pessoaInsert.setDescricao(pessoaRequest.getDescricao());
					pessoaInsert.setEndereco(pessoaRequest.getEndereco());
					pessoaInsert.setListaamigos(pessoaRequest.getListaamigos());
					return pessoaRepository.save(pessoaInsert);
				}).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada: " +pessoaId));
	}

	@PutMapping("/pessoa/{pessoaId}/addListaAmigos")
	public Pessoa addAmigosblock(@PathVariable Long listaAmigosId,
			@Valid @RequestBody ListaAmigos listaAmigos) {
		return pessoaRepository.findById(listaAmigosId)
				.map(lista-> {
					lista.addListaAmigos(listaAmigos);
					return pessoaRepository.save(lista);
				}).orElseThrow(()-> new ResourceNotFoundException("Amigo bloqueado não encortado:" + listaAmigosId));

	}


	@DeleteMapping("/pessoa/{pessoaId}")
	public ResponseEntity<?> deletePessoa(@PathVariable Long pessoaId){
		return pessoaRepository.findById(pessoaId)
				.map(deletePessoa -> {
					pessoaRepository.delete(deletePessoa);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada: " +pessoaId));

	}

}
