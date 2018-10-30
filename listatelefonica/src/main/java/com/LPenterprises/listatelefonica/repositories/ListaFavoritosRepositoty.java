package com.LPenterprises.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LPenterprises.listatelefonica.model.ListaFavoritos;

@Repository
public interface ListaFavoritosRepositoty  extends JpaRepository<ListaFavoritos, Long>{

}
