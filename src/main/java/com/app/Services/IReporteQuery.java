package com.app.Services;

import java.util.List;

import com.app.DTO.ParcialExtendReporte;
import com.app.DTO.PreguntaPrincipalDTO;
import com.app.Entity.PreguntaPrincipal;

public interface IReporteQuery {
	
	
	List<PreguntaPrincipalDTO> obtenerPreguntasReporteUsuario(int idReporte, int idUsuario);
	List<ParcialExtendReporte> obtenerReportesByParcial(List<Integer> idParcial, int idUsuario);
	boolean guardarRespuestasReporte(List<PreguntaPrincipalDTO> pregunta, int idCliente);

}
