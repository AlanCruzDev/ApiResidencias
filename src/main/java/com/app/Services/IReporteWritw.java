package com.app.Services;

import java.util.List;

import com.app.DTO.PreguntaPrincipalDTO;

public interface IReporteWritw {
	
	boolean guardarRespuestasUsuario(List<PreguntaPrincipalDTO> cuestionario, int idUsuario);

}
