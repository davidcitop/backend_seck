package com.servipack.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servipack.model.Horario;
import com.servipack.service.HorarioService;


@CrossOrigin(origins={"http://localhost:4200","*"},maxAge=3600)
@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
	@Autowired
	private HorarioService horariodocente;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@PostMapping
	private ResponseEntity<?> guardar (@RequestBody Horario horario, BindingResult result){
		
		Horario horarionew = null;
		Horario horarioAula= null;
		Date nuevaFecha;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			try {
				nuevaFecha= sdf.parse(sdf.format(horario.getHorFechaInicio()));
				horarioAula = horariodocente.findByIdAula(horario.getAula().getAulCodigo(), nuevaFecha);				
				if(horarioAula!=null) {
					System.out.println("Ya est[a asiganada a esa hora la clase");

				}else {
					horario.setHorFechaInicio(sdf.parse(sdf.format(horario.getHorFechaInicio())));
					horario.setHorFechaFin(sdf.parse(sdf.format(horario.getHorFechaFin())));

					horarionew = horariodocente.create(horario);

					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			

			
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Horario ha sido creado con éxito!");
		response.put("horario", horarionew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
				
	}
	@GetMapping
	private ResponseEntity<List<Horario>> listarHorarios (){
		return ResponseEntity.ok(horariodocente.getAllHorario());
		
	}
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Horario> delete (@PathVariable ("id") Long id){
		horariodocente.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Horario>> listarHorariosid (@PathVariable ("id") Long id){
		return ResponseEntity.ok(horariodocente.findById(id));
		
	}

	@PutMapping (value = "{id}")
	private ResponseEntity<?> editar (@RequestBody Horario u,@PathVariable ("id") Long id){
		
		Horario horarionew = null;
		Horario horarioAula= null;
		Date nuevaFecha;
		Map<String, Object> response = new HashMap<>();
		
		try {
			try {
				nuevaFecha= sdf.parse(sdf.format(u.getHorFechaInicio()));
				horarioAula = horariodocente.findByIdAula(u.getAula().getAulCodigo(), nuevaFecha);
			
				if(horarioAula!=null) {
					System.out.println("Ya est[a asiganada a esa hora la clase");

				}else {
					u.setHorFechaInicio(sdf.parse(sdf.format(u.getHorFechaInicio())));
					u.setHorFechaFin(sdf.parse(sdf.format(u.getHorFechaFin())));
					u.setHorCodigo(id);
					horarionew = horariodocente.editar(u);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El Horario ha sido actualziado con éxito!");
		response.put("horario", horarionew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	


}
