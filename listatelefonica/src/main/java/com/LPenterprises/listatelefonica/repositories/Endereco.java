package com.LPenterprises.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Endereco extends JpaRepository<Endereco, Long>{

}
