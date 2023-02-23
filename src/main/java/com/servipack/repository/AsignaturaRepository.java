package com.servipack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servipack.model.Asignatura;



@Repository

public interface AsignaturaRepository extends JpaRepository<Asignatura, String>{

}

