package com.app.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permisos implements Serializable{
	
	 @Id
	 @Column(name = "idPermisos")
	 private Long idPermisos;
	 private Integer idReporte;
	 private Integer idParcial;
	 private Integer idRol;
	 private Date fechaInicio;
	 private Date fechaFinal;
	 private Integer habilitar;
	 
	public Long getIdPermisos() {
		return idPermisos;
	}
	public void setIdPermisos(Long idPermisos) {
		this.idPermisos = idPermisos;
	}
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public Integer getIdParcial() {
		return idParcial;
	}
	public void setIdParcial(Integer idParcial) {
		this.idParcial = idParcial;
	}
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Integer getHabilitar() {
		return habilitar;
	}
	public void setHabilitar(Integer habilitar) {
		this.habilitar = habilitar;
	}
	 
	 
	 
}
