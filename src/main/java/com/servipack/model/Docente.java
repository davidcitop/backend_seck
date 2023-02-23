package com.servipack.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "docente")

public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "doc_codigo", unique = true, nullable = false, length = 13)
	private String docCodigo;
	@Column(name = "doc_nombre", nullable = true, length = 300)
    private String docNombre;
    @Column(name = "doc_activo", nullable = true)
    private boolean docActivo;

}
