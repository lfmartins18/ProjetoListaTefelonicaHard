package com.LPenterprises.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaAmigos extends JpaRepository<ListaAmigos, Long>{

}
