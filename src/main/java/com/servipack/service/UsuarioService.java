package com.servipack.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servipack.model.RolSistema;
import com.servipack.model.Usuario;
import com.servipack.repository.UsuarioRepository;


@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario create (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public Page<Usuario> getAllUsuarioPage(Pageable pageable){
		return usuarioRepository.findAll(pageable);
	}
	public List<Usuario> getAllUsuario(){
		return usuarioRepository.findAll();
	}
	public void delete (String id) {
		usuarioRepository.deleteById(id);
	}
	//public void delete (Persona persona) {
		// personarepository.delete(persona);
	//}
	
	public Usuario findById (String id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		return usuarioOptional.orElse(null);
	}
	
	public Usuario editar (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String usuCodigo) throws UsernameNotFoundException {
		System.out.println(usuCodigo);

		Usuario usuarioNew = usuarioRepository.findByUsuCodigo(usuCodigo);
		
		
		if(usuarioNew == null) {
			logger.error("Erro en el login: No existe el usuario'"+usuCodigo+"' en el sistema");
			throw new UsernameNotFoundException("Erro en el login: No existe el usuario'"+usuCodigo+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuarioNew.getRolSistema()
				.stream()
				.map(role ->new SimpleGrantedAuthority(role.getRolNombre()))
				.peek(authority -> logger.info("Role: "+authority.getAuthority()))
				.collect(Collectors.toList());
				//logger.info("");
		return new User(usuarioNew.getUsuCodigo(), usuarioNew.getUsuContrasena(), usuarioNew.isUsuActivo(), true, true, true, authorities);
	}
	
	@Override
	@Transactional(readOnly = true)
	    public Usuario findByUsuCodigo(String usuCodigo) {
	        return usuarioRepository.findByUsuCodigo(usuCodigo);
	    }
	
	public void createRol (String usuCodigo, String rolsCodigo ) {
		 usuarioRepository.insertIntoUsuarioRoles(usuCodigo, rolsCodigo);
	}
	
	public List<RolSistema> getAllRolSistema(){
		return usuarioRepository.findByRol();
	}
	

}
