package com.app.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Modulo implements Serializable{
	

	@javax.persistence.Id
	@Column(name="idModulo")
	private Integer Id;
	
	@Column(name = "nombre")
	private String nombre;
	
	
	public Modulo() {
		
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private static final long serialVersionUID = 1L;
}
