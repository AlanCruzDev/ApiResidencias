package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autorizacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name = "idAutorizacion")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	
	public Autorizacion() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
