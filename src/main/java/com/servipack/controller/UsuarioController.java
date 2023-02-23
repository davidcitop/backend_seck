package com.servipack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servipack.model.RolSistema;
import com.servipack.model.Usuario;
import com.servipack.service.UsuarioService;



@CrossOrigin(origins={"http://localhost:4200","*"},maxAge=3600)
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioservice;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping
	private ResponseEntity<?> guardar (@RequestBody Usuario usuario, BindingResult result){
		Usuario usuarioNew = null;
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
			usuario.setUsuContrasena(passwordEncoder.encode(usuario.getUsuContrasena()));
			usuarioNew = usuarioservice.create(usuario);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("usuario", usuarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@GetMapping
	private ResponseEntity<List<Usuario>> listarUsuarios (){
		return ResponseEntity.ok(usuarioservice.getAllUsuario());
		
	}
	
	@GetMapping("/page/{page}")
	private Page<Usuario> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 10, Sort.by("usuCodigo").descending());
		return usuarioservice.getAllUsuarioPage(pageable);
		
	}
	
	@DeleteMapping(value = "{id}")
	private ResponseEntity<?> delete (@PathVariable ("id") String id){
		Map<String, Object> response = new HashMap<>();
		
		try {						
			usuarioservice.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el usuario de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping (value = "{id}")
	private ResponseEntity<?> listarUsuariosid (@PathVariable ("id") String id){
		Usuario usuario = null;
		Map<String, Object> response = new HashMap<>();
		try {
			usuario = usuarioservice.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(usuario == null) {
			response.put("mensaje", "El usuario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}

	@PutMapping (value = "{id}")
	private ResponseEntity<?> editar (@RequestBody Usuario u,BindingResult result,@PathVariable ("id") String id){
		Usuario usuarioActual = usuarioservice.findById(id);

		Usuario usuarioUpdated = null;

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (usuarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el usuario ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			u.setUsuCodigo(id);
			usuarioUpdated = usuarioservice.editar(u);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con éxito!");
		response.put("usuario", usuarioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/roluser")
	public ResponseEntity<?> rolUser(@RequestParam("usuCodigo") String usuCodigo,@RequestParam("rolsCodigo") String rolsCodigo ){
		Map<String, Object> response = new HashMap<>();

		
		usuarioservice.createRol(usuCodigo,rolsCodigo);

		response.put("usuario", usuCodigo);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

			
	}
	
	@GetMapping("/roles")
	private ResponseEntity<List<RolSistema>> listarRoles (){
		return ResponseEntity.ok(usuarioservice.getAllRolSistema());
		
	}

}
