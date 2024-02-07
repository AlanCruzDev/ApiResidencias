package com.app.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOREPORTES")
public class UsuarioReportes implements Serializable {
	
	
	@javax.persistence.Id
	@Column(name = "idUsuarioReportes")
	private Long Id;
	
	@Column(name="idUsuario")
	private int idUsuario;
	
	@Column(name="idReporte")
    private int idReporte;
    
	@Column(name="fechaCreacion")
    private Date fechaCreacion;
    
	@Column(name="estatus")
    private int estatus;

	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	private static final long serialVersionUID = 1L;
}
