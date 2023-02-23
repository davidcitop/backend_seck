package com.servipack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servipack.model.Aula;


@Repository
public interface AulaRepository extends JpaRepository<Aula, String>{


}
