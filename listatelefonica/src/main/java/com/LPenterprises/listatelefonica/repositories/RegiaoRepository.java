package com.LPenterprises.listatelefonica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LPenterprises.listatelefonica.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

}
