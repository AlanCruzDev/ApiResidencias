package com.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ParcialExtendReporte;
import com.app.DTO.PreguntaPrincipalDTO;
import com.app.Entity.PreguntaPrincipal;
import com.app.Repository.ReporteRepositoryQuery;

@Service
public class ReporteQueryImpl implements IReporteQuery{
	
	
	@Autowired
	private ReporteRepositoryQuery reporteRepositoryQuery;
	
	
	@Autowired
	private RepositoryWriteImpl  repositoryWriteImpl;

	@Override
	public List<PreguntaPrincipalDTO> obtenerPreguntasReporteUsuario(int idReporte, int idUsuario) {
		return reporteRepositoryQuery.obtenerCuestionarioByReporteUsuario(idReporte, idUsuario);
	}

	

	@Override
	public boolean guardarRespuestasReporte(List<PreguntaPrincipalDTO> pregunta, int idCliente) {
		return repositoryWriteImpl.guardarRespuestasUsuario(pregunta, idCliente);
	}



	@Override
	public List<ParcialExtendReporte> obtenerReportesByParcial(List<Integer> idParcial, int idUsuario) {
		return reporteRepositoryQuery.obtenerReportesByParcial(idParcial,idUsuario);
	}
}
