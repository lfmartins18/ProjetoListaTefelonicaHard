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
import com.LPenterprises.listatelefonica.model.ListaBlock;
import com.LPenterprises.listatelefonica.repositories.ListaBlockRepository;

@RestController
public class ListaBlockController {

	@Autowired
	ListaBlockRepository blockRepository;
	

    @GetMapping("/lista_block")
    public Page<ListaBlock> getListaBlock (Pageable pageable){
    	return blockRepository.findAll(pageable);
    }
 
    @PostMapping("/lista_block")
    public ListaBlock cretaeListaBlock (@Valid @RequestBody ListaBlock block) {
     return blockRepository.save(block);	
    }

    @PutMapping("/lista_block/{blockId}")
    public ListaBlock updateListaBlock(@PathVariable Long blockId,
    		@Valid @RequestBody ListaBlock blockRequest) {
    	return blockRepository.findById(blockId)
    			.map(blockInsert -> {
    				blockInsert.setMotivoBloqueio(blockRequest.getMotivoBloqueio());     
    			   return blockRepository.save(blockInsert);
    			}).orElseThrow(() -> new ResourceNotFoundException("Erro!" +blockId));
    }

    @DeleteMapping("/lista_block/{blockId}")
    public ResponseEntity<?> deleteBlock(@PathVariable Long blockId){
    	return blockRepository.findById(blockId)
    			.map(blockDelete -> {
    				blockRepository.delete(blockDelete);
    			    return ResponseEntity.ok().build();
    			}).orElseThrow(() -> new ResourceNotFoundException("Erro!" +blockId));
    }
    
}
