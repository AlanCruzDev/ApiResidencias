package com.app.DTO;

import java.util.List;

public class ParcialExtendReporte {
	
	private Long IdParcial;
	private String NombreParcial;
	private String Descripcion;
	private List<ReporteDTO> reporteDTOs;

	public List<ReporteDTO> getReporteDTOs() {
		return reporteDTOs;
	}
	public void setReporteDTOs(List<ReporteDTO> reporteDTOs) {
		this.reporteDTOs = reporteDTOs;
	}
	public Long getIdParcial() {
		return IdParcial;
	}
	public void setIdParcial(Long idParcial) {
		IdParcial = idParcial;
	}
	public String getNombreParcial() {
		return NombreParcial;
	}
	public void setNombreParcial(String nombreParcial) {
		NombreParcial = nombreParcial;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
