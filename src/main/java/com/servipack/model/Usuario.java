package com.servipack.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "usu_codigo", unique = true, nullable = false, length = 13)
	private String usuCodigo;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usu_codigo"),
	inverseJoinColumns=@JoinColumn(name="rol_codigo"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usu_codigo", "rol_codigo"})})
	private List<RolSistema> rolSistema;
	@Column(name = "usu_nombre", nullable = true, length = 300)
    private String usuNombre;
	@Column(name = "usu_movil", nullable = true, length = 50)
	private String usuMovil;
	@Column(name = "usu_contrasena", nullable = true, length = 100)
    private String usuContrasena;
    @Column(name = "usu_activo", nullable = true)
    private boolean usuActivo;

}
