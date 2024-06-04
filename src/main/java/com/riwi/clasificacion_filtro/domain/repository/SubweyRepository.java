package com.riwi.clasificacion_filtro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.clasificacion_filtro.domain.entities.Subwey;

@Repository
public interface SubweyRepository extends JpaRepository<Subwey, Long>{
  
}
