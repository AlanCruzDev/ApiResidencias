package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PerfilPermisos implements Serializable{

	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	@Column(name = "idPerfilPermisos")
	private Integer Id;
	@Column(name = "idrol")
	private Integer idrol;
	@Column(name="idmodulo")
	private Integer idmodulo;
	@Column(name="idautorizacion")
	private Integer idautorizacion;
	@Column(name="status")
	private Integer status;
	
	
	public PerfilPermisos() {
		
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getIdrol() {
		return idrol;
	}


	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}


	public Integer getIdmodulo() {
		return idmodulo;
	}


	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}


	public Integer getIdautorizacion() {
		return idautorizacion;
	}


	public void setIdautorizacion(Integer idautorizacion) {
		this.idautorizacion = idautorizacion;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}

}
