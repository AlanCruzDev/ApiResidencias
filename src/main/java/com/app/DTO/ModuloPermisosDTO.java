package com.app.DTO;

import java.util.List;

import com.app.Entity.Autorizacion;

public class ModuloPermisosDTO {

	private Integer idModulo;
	private String nombre;
	private List<Autorizacion> autorizaciones;

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Autorizacion> getAutorizaciones() {
		return autorizaciones;
	}

	public void setAutorizaciones(List<Autorizacion> autorizaciones) {
		this.autorizaciones = autorizaciones;
	}

}
