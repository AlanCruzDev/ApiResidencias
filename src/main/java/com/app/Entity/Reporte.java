package com.app.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Reporte implements Serializable {
	
	@Id
	@Column(name = "IdReporte")
	private Long IdReporte;
	
	
	@Column(name="NombreReporte")
	private String NombreReporte;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column(name="FechaCreacion")
	private Date FechaCreacion;
	
	@Column(name="habilitado")
	private Integer habilitado;
	
	
	public Reporte() {
		
	}

	public Long getIdReporte() {
		return IdReporte;
	}

	public void setIdReporte(Long idReporte) {
		IdReporte = idReporte;
	}

	public String getNombreReporte() {
		return NombreReporte;
	}

	public void setNombreReporte(String nombreReporte) {
		NombreReporte = nombreReporte;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public Integer getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Integer habilitado) {
		this.habilitado = habilitado;
	}
	
	
}
