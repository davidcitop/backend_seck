package com.servipack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servipack.model.RolSistema;
import com.servipack.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	@Query("select u from Usuario u where u.usuCodigo=?1")
	public Usuario findByUsuCodigo(String usuCodigo);
	
	@Modifying
	@Query(value = "insert into usuarios_roles (usu_codigo, rols_codigo) VALUES (?1, ?2)", nativeQuery = true)
	void insertIntoUsuarioRoles(String usuCodigo , String rolsCodigo);

	@Query("select r from RolSistema r")
	public List<RolSistema> findByRol();
}
