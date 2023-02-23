package com.servipack.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servipack.model.Horario;
import com.servipack.repository.HorarioRepository;


@Service
public class HorarioService {
	
	@Autowired
	private HorarioRepository horarioRepository;

	public Horario create (Horario horario) {
		return horarioRepository.save(horario);
	}
	public Page<Horario> getAllHorarioPage(Pageable pageable){
		return horarioRepository.findAll(pageable);
	}
	public List<Horario> getAllHorario(){
		return horarioRepository.findAll();
	}
	public void delete (Long id) {
		horarioRepository.deleteById(id);
	}
	public Optional<Horario> findById (Long id) {
		return horarioRepository.findById(id);
	}
	
	public Horario findByIdAula (String id, Date HorFechaInicio) {
		return horarioRepository.horByAula(id, HorFechaInicio);
	}
	
	public Horario editar (Horario horario) {
		return horarioRepository.save(horario);
	}


}
