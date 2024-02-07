package com.app.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PreguntaPrincipal implements Serializable{
	
	@Id
	@Column(name = "idPreguntaPrincipal")
	private Long idPreguntaPrincipal;
	private Integer idReporte;
    private String titulo;
    private Integer orden;
    private Integer activo;
    private Integer saltoPagina;
    
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
