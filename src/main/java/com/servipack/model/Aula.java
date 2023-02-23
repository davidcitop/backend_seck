package com.servipack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "aula")

public class Aula implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "aul_codigo", unique = true, nullable = false, length = 5)
	private String aulCodigo;
	@Column(name = "aul_nombre", nullable = true, length = 150)
	private String aulNombre;
	@Column(name = "aul_descripcion", nullable = true, length = 150)
	private String aulDescripcion;

}
