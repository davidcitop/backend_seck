package com.servipack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servipack.model.Docente;
import com.servipack.repository.DocenteRepository;

@Service
public class DocenteService {
	@Autowired
	private DocenteRepository docenteRepository;

	public Docente create (Docente docente) {
		return docenteRepository.save(docente);
	}
	public Page<Docente> getAllDocentePage(Pageable pageable){
		return docenteRepository.findAll(pageable);
	}
	public List<Docente> getAllDocente(){
		return docenteRepository.findAll();
	}
	public void delete (String id) {
		docenteRepository.deleteById(id);
	}
	public Optional<Docente> findById (String id) {
		return docenteRepository.findById(id);
	}
	public Docente editar (Docente docente) {
		return docenteRepository.save(docente);
	}


}
