package com.app.DTO;

import java.util.Date;

public class ReporteDTO {
	
	private Long IdReporte;
	private String NombreReporte;
	private String codigo;
	private Date FechaCreacion;
	private Integer habilitado;
	
	public ReporteDTO() {
		
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
	
}
