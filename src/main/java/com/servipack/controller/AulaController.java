package com.servipack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servipack.model.Aula;
import com.servipack.service.AulaService;


@CrossOrigin(origins={"http://localhost:4200","*"},maxAge=3600)
@RestController
@RequestMapping("/api/aulas")
public class AulaController {
	
	@Autowired
	private AulaService aulaservice;
	
	@PostMapping
	private ResponseEntity<Aula> guardar (@RequestBody Aula aula){
		return ResponseEntity.ok(aulaservice.create(aula));
		
	}
	@GetMapping
	private ResponseEntity<List<Aula>> listarAulas (){
		return ResponseEntity.ok(aulaservice.getAllAula());
		
	}
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Aula> delete (@PathVariable ("id") String id){
		aulaservice.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Aula>> listarAulasid (@PathVariable ("id") String id){
		return ResponseEntity.ok(aulaservice.findById(id));
		
	}

	@PutMapping (value = "{id}")
	private ResponseEntity<Aula> editar (@RequestBody Aula u,@PathVariable ("id") String id){
		u.setAulCodigo(id);
		return ResponseEntity.ok(aulaservice.editar(u));
	}
	

}
