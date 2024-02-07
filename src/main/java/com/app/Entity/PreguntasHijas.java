package com.app.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PreguntasHijas {
	
	@Id
	@Column(name = "idPreguntasHijas")
	private Long idPreguntasHijas;
	private String  pregunta;
	private Integer IdTipo;
	private Integer orden;
	private Integer activo;
	private Integer idPreguntaPrincipal;
	
	
	public Integer getIdPreguntaPrincipal() {
		return idPreguntaPrincipal;
	}
	public void setIdPreguntaPrincipal(Integer idPreguntaPrincipal) {
		this.idPreguntaPrincipal = idPreguntaPrincipal;
	}
	public Long getIdPreguntasHijas() {
		return idPreguntasHijas;
	}
	public void setIdPreguntasHijas(Long idPreguntasHijas) {
		this.idPreguntasHijas = idPreguntasHijas;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public Integer getIdTipo() {
		return IdTipo;
	}
	public void setIdTipo(Integer idTipo) {
		IdTipo = idTipo;
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

}
