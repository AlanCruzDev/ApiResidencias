package com.app.DTO;

import java.util.List;

public class PreguntasHijasDTO {
	
	private Long idPreguntaHija;
    private String pregunta;
    private Long tipo;
    private Integer activo;
    private Integer orden;
    private String respuestaUsuario;
    private List<ParticipantesProyectoDTO> participantesProyectos;

    public Integer getOrder() {
        return orden;
    }

    public void setOrder(Integer orden) {
        this.orden = orden;
    }

    public List<ParticipantesProyectoDTO> getParticipantesProyectos() {
        return participantesProyectos;
    }

    public void setParticipantesProyectos(List<ParticipantesProyectoDTO> participantesProyectos) {
        this.participantesProyectos = participantesProyectos;
    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public Long getIdPreguntaHija() {
        return idPreguntaHija;
    }

    public void setIdPreguntaHija(Long idPreguntaHija) {
        this.idPreguntaHija = idPreguntaHija;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Long getIdTipo() {
        return tipo;
    }

    public void setIdTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
	
	
	
}
