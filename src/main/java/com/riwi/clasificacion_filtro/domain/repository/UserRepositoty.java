package com.riwi.clasificacion_filtro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.clasificacion_filtro.domain.entities.User;

@Repository
public interface UserRepositoty 
    extends JpaRepository<User, Long>{

}
