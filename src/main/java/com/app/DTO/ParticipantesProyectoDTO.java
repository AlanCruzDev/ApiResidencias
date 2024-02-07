package com.app.DTO;

public class ParticipantesProyectoDTO {
	 private Long idParticipanteProyecto;
	    private String nombre;
	    private String carrera;
	    private Integer id_Usuario;
	    private Integer idPreguntaHija;

	    public Long getIdParticipanteProyecto() {
	        return idParticipanteProyecto;
	    }

	    public void setIdParticipanteProyecto(Long idParticipanteProyecto) {
	        this.idParticipanteProyecto = idParticipanteProyecto;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getCarrera() {
	        return carrera;
	    }

	    public void setCarrera(String carrera) {
	        this.carrera = carrera;
	    }

	    public Integer getId_Usuario() {
	        return id_Usuario;
	    }

	    public void setId_Usuario(Integer id_Usuario) {
	        this.id_Usuario = id_Usuario;
	    }

	    public Integer getIdPreguntaHija() {
	        return idPreguntaHija;
	    }

	    public void setIdPreguntaHija(Integer idPreguntaHija) {
	        this.idPreguntaHija = idPreguntaHija;
	    }

}
