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

import com.servipack.model.Docente;
import com.servipack.service.DocenteService;

@CrossOrigin(origins={"http://localhost:4200","*"},maxAge=3600)
@RestController
@RequestMapping("/api/docentes")
public class DocenteController {
	@Autowired
	private DocenteService docenteservice;
	
	@PostMapping
	private ResponseEntity<Docente> guardar (@RequestBody Docente docente){
		return ResponseEntity.ok(docenteservice.create(docente));
		
	}
	@GetMapping
	private ResponseEntity<List<Docente>> listarDocentes (){
		return ResponseEntity.ok(docenteservice.getAllDocente());
		
	}
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Docente> delete (@PathVariable ("id") String id){
		docenteservice.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Docente>> listarDiasid (@PathVariable ("id") String id){
		return ResponseEntity.ok(docenteservice.findById(id));
		
	}

	@PutMapping (value = "{id}")
	private ResponseEntity<Docente> editar (@RequestBody Docente u,@PathVariable ("id") String id){
		u.setDocCodigo(id);
		return ResponseEntity.ok(docenteservice.editar(u));
	}
	

}
