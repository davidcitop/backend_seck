package com.servipack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servipack.model.Docente;


@Repository
public interface DocenteRepository extends JpaRepository<Docente, String>{

}
