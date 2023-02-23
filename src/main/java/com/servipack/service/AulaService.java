package com.servipack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servipack.model.Aula;
import com.servipack.repository.AulaRepository;


@Service
public class AulaService {
	@Autowired
	private AulaRepository aulaRepository;

	public Aula create (Aula aula) {
		return aulaRepository.save(aula);
	}
	public Page<Aula> getAllAulaPage(Pageable pageable){
		return aulaRepository.findAll(pageable);
	}
	public List<Aula> getAllAula(){
		return aulaRepository.findAll();
	}
	public void delete (String id) {
		aulaRepository.deleteById(id);
	}
	
	public Optional<Aula> findById (String id) {
		return aulaRepository.findById(id);
	}
	public Aula editar (Aula aula) {
		return aulaRepository.save(aula);
	}


}
