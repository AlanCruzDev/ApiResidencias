package com.app.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	private String apellidopaterno;
	private String apellidomaterno;
	
	@Column(name = "matricula")
	private String matricula;
	private String contrasenia;
	private Integer status;
	private String correoinstitucional;
	private Integer primerinicio;
	private Integer edad;
	private Date fecharegistro;
	
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCorreoinstitucional() {
		return correoinstitucional;
	}
	public void setCorreoinstitucional(String correoinstitucional) {
		this.correoinstitucional = correoinstitucional;
	}
	public Integer getPrimerinicio() {
		return primerinicio;
	}
	public void setPrimerinicio(Integer primerinicio) {
		this.primerinicio = primerinicio;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
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
