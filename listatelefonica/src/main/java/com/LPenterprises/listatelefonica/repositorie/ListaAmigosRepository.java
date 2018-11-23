package com.LPenterprises.listatelefonica.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LPenterprises.listatelefonica.model.ListaAmigos;

@Repository
public interface ListaAmigosRepository extends JpaRepository<ListaAmigos, Long>{

}
