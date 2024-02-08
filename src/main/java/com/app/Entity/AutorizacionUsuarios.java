package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AutorizacionUsuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@Column(name = "idAutorizacionUsuario")
	private Integer Id;
	
	
	@Column(name="idModulo")
	private Integer idModulo;
	
	
	@Column(name="idusuario")
	private Integer idusuario;
	
	
	@Column(name="idAutorizacion")
	private Integer idAutorizacion;
	
	@Column(name="status")
	private Integer status;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	public Integer getIdAutorizacion() {
		return idAutorizacion;
	}

	public void setIdAutorizacion(Integer idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
