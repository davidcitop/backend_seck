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

import com.servipack.model.Asignatura;
import com.servipack.service.AsignaturaService;



//@CrossOrigin(origins = "*")
@CrossOrigin(origins={"http://localhost:4200","*"},maxAge=3600)
@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {
	@Autowired
	private AsignaturaService asignaturaservice;
	
	@PostMapping
	private ResponseEntity<Asignatura> guardar (@RequestBody Asignatura asignatura){
		return ResponseEntity.ok(asignaturaservice.create(asignatura));
		
	}
	@GetMapping
	private ResponseEntity<List<Asignatura>> listarAsignaturas (){
		return ResponseEntity.ok(asignaturaservice.getAllAsignatura());
		
	}
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Asignatura> delete (@PathVariable ("id") String id){
		asignaturaservice.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Asignatura>> listarAsignaturasid (@PathVariable ("id") String id){
		return ResponseEntity.ok(asignaturaservice.findById(id));
		
	}

	@PutMapping (value = "{id}")
	private ResponseEntity<Asignatura> editar (@RequestBody Asignatura u,@PathVariable ("id") String id){
		u.setAsgCodigo(id);;
		return ResponseEntity.ok(asignaturaservice.editar(u));
	}
	
}
