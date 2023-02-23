package com.servipack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servipack.model.Asignatura;
import com.servipack.repository.AsignaturaRepository;




@Service
public class AsignaturaService {
	
	@Autowired
	private AsignaturaRepository asignaturaRepository;

	public Asignatura create (Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}
	public Page<Asignatura> getAllAsignaturaPage(Pageable pageable){
		return asignaturaRepository.findAll(pageable);
	}
	public List<Asignatura> getAllAsignatura(){
		return asignaturaRepository.findAll();
	}
	public void delete (String id) {
		asignaturaRepository.deleteById(id);
	}
	
	public Optional<Asignatura> findById (String id) {
		return asignaturaRepository.findById(id);
	}
	public Asignatura editar (Asignatura asignatura) {
		return asignaturaRepository.save(asignatura);
	}


}
