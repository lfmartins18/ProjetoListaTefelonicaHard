package com.LPenterprises.listatelefonica.controller;

import javax.validation.Valid;

import org.hibernate.mapping.ValueVisitor;
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
import com.LPenterprises.listatelefonica.model.ListaFavoritos;
import com.LPenterprises.listatelefonica.repositories.ListaFavoritosRepositoty;

@RestController
public class FavoritosController {
    @Autowired
	ListaFavoritosRepositoty favoritosRepository;
	
	@GetMapping("lista_favoritos")
	public Page<ListaFavoritos> getListaFavoritos(Pageable pageable){
	 return favoritosRepository.findAll(pageable);	
	}
	
    @PostMapping("lista_favoritos")
    public ListaFavoritos createFavoriteList (@Valid @RequestBody ListaFavoritos favoritos) {
    	return favoritosRepository.save(favoritos);
    }

   @PutMapping("/lista_favoritos/{favoritosId}")
   public ListaFavoritos updateListaFavoritos(@PathVariable Long favoritosId,
		   @Valid @RequestBody ListaFavoritos favoritosRequest) {
	       return favoritosRepository.findById(favoritosId)
	    		   .map(favoritosInsert -> {
	    			   favoritosInsert.setMotivoFavorito(favoritosRequest.getMotivoFavorito());
	    		       return favoritosRepository.save(favoritosInsert);
	    		   }).orElseThrow(() -> new ResourceNotFoundException("Erro" +favoritosId));
   }

  @DeleteMapping("/lista_favoritos/{favoritosId}")
  public ResponseEntity<?> deleteFavorito(@PathVariable Long favoritosId){
	  return favoritosRepository.findById(favoritosId)
			  .map(deleteFavorito -> {
				  favoritosRepository.delete(deleteFavorito);
			      return ResponseEntity.ok().build();
			  }).orElseThrow(() -> new ResourceNotFoundException("Erro" +favoritosId));
  }
}
