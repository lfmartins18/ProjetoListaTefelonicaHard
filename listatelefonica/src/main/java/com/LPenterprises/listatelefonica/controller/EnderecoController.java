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
import com.LPenterprises.listatelefonica.model.Endereco;
import com.LPenterprises.listatelefonica.repositorie.EnderecoRepository;

@RestController
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/endereco")
	public Page<Endereco> getEnderecos (Pageable pageable){
		return enderecoRepository.findAll(pageable);
	}

   @PostMapping("/endereco")
   public Endereco createEndereco (@Valid @RequestBody Endereco endereco) {
	   return enderecoRepository.save(endereco);
   }

   @PutMapping("/endereco/{enderecoId}")
   public Endereco updateEndereco(@PathVariable Long enderecoId,
		   @Valid @RequestBody Endereco enderecoRequest) {
	   return enderecoRepository.findById(enderecoId)
			   .map(enderecoInsert -> {
				 enderecoInsert.setBairro(enderecoRequest.getBairro());
				 enderecoInsert.setNumCasa(enderecoRequest.getNumCasa());
                 enderecoInsert.setNumCasa(enderecoRequest.getNumCasa());
				 
				 return enderecoRepository.save(enderecoInsert);
			   }).orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado: " +enderecoId));
	   
   }
 
   @DeleteMapping("endereco/{enderecoId}")
   public ResponseEntity<?> deleteEndereco(@PathVariable Long enderecoId){
	   return enderecoRepository.findById(enderecoId)
       .map(deleteEndereco -> {
    	   enderecoRepository.delete(deleteEndereco);
    	   return ResponseEntity.ok().build();
       }).orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada: " +enderecoId));
   }

}

