package com.app.DTO;

import java.util.List;

public class PreguntaPrincipalDTO {
	
	private Long idPreguntaPrincipal;
	private Integer idReporte;
    private String titulo;
    private Integer orden;
    private Integer activo;
    private Integer saltoPagina;
    private List<PreguntasHijasDTO>hijasDTOs;
    
    
	public List<PreguntasHijasDTO> getHijasDTOs() {
		return hijasDTOs;
	}
	public void setHijasDTOs(List<PreguntasHijasDTO> hijasDTOs) {
		this.hijasDTOs = hijasDTOs;
	}
	public Long getIdPreguntaPrincipal() {
		return idPreguntaPrincipal;
	}
	public void setIdPreguntaPrincipal(Long idPreguntaPrincipal) {
		this.idPreguntaPrincipal = idPreguntaPrincipal;
	}
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getActivo() {
		return activo;
	}
	public void setActivo(Integer activo) {
		this.activo = activo;
	}
	public Integer getSaltoPagina() {
		return saltoPagina;
	}
	public void setSaltoPagina(Integer saltoPagina) {
		this.saltoPagina = saltoPagina;
	}
    
    
    

}
