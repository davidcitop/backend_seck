package com.servipack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "asignatura")

public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "asg_codigo", unique = true, nullable = false, length = 5)
	private String asgCodigo;
	@Column(name = "asg_nombre", nullable = true, length = 150)
	private String asgNombre;
	@Column(name = "asg_descripcion", nullable = true, length = 150)
	private String asgDescripcion;

}
