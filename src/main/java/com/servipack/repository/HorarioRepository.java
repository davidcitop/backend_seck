package com.servipack.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servipack.model.Horario;


@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{
	
	@Query("select h from Horario h where h.aula.aulCodigo=?1 and h.horFechaInicio=?2")
	public Horario horByAula(String aulCodigo, Date HorFechaInicio);
	
}
