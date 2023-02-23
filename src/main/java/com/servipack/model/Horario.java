package com.servipack.model;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
@Table(name = "horario")

public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hor_codigo", unique = true, nullable = false)
	private long horCodigo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "asg_codigo")
	private Asignatura asignatura;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "aul_codigo")
	private Aula aula;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "doc_codigo")
	private Docente docente;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usu_codigo")
	private Usuario usuario;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "hor_fecha_inicio", length = 13)
	private Date horFechaInicio;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "hor_fecha_fin", length = 13)
	private Date horFechaFin;

}
