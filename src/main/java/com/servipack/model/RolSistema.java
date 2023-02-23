package com.servipack.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rol_sistema")
public class RolSistema implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "rol_codigo", unique = true, nullable = false, length = 13)
	private String rolCodigo;
	@Column(name = "rol_nombre", nullable = true, length = 150)
	private String rolNombre;

}
