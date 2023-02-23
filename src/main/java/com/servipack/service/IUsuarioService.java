package com.servipack.service;

import org.springframework.data.jpa.repository.Query;

import com.servipack.model.Usuario;

public interface IUsuarioService {
	@Query("select u from Usuario u where u.usuCodigo=?1")
	public Usuario findByUsuCodigo(String usuCodigo);

}
