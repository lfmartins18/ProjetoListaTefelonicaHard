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
import com.LPenterprises.listatelefonica.model.Regiao;
import com.LPenterprises.listatelefonica.repositories.RegiaoRepository;

@RestController
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@GetMapping("/regiao")
	public Page<Regiao> getRegiao(Pageable pageable){
		return regiaoRepository.findAll(pageable);
			
	}
	
	@PostMapping("/regiao")
	public Regiao createRegiao(@Valid @RequestBody Regiao regiao) {
		return regiaoRepository.save(regiao);	
	}
	
	
	@PutMapping("/regiao/{regiaoId}")
	public Regiao uptadeRegiao(@PathVariable Long regiaoId,
						@Valid @RequestBody Regiao regiaoRequest) {
		return regiaoRepository.findById(regiaoId)
			.map(usuarioInsert -> {
				usuarioInsert.setCep(regiaoRequest.getCep());
			    usuarioInsert.setCidade(regiaoRequest.getCidade());
			    usuarioInsert.setEstado(regiaoRequest.getEstado());
			    usuarioInsert.setNacionalidade(regiaoRequest.getNacionalidade());
			    return regiaoRepository.save(usuarioInsert);
			}).orElseThrow(() -> new ResourceNotFoundException("Erro" +regiaoId));
				
	}
		
	@DeleteMapping("/regiao/{regiaoId}")
	public ResponseEntity<?> deleteRegiao(@PathVariable long regiaoId){
		return regiaoRepository.findById(regiaoId)
				.map(deleteRegiao -> {
					regiaoRepository.delete(deleteRegiao);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("Erro" +regiaoId));
		
	}
}
