package com.LPenterprises.listatelefonica.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LPenterprises.listatelefonica.model.ListaBlock;

@Repository
public interface ListaBlockRepository extends JpaRepository<ListaBlock, Long>{

}
