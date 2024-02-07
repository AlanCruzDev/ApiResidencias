package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ParcialExtendReporte;
import com.app.DTO.PreguntaPrincipalDTO;
import com.app.Services.IReporteQuery;

@RestController
@RequestMapping("v1/reporte")
public class ReporteController {
	
	
	@Autowired
	private IReporteQuery iReporteQuery;
	
	@GetMapping("/preguntas/{idReporte}/{idUsuario}")
	public List<PreguntaPrincipalDTO> getPreguntasReporte(@PathVariable("idReporte") int idReporte, @PathVariable("idUsuario") int idUsuario) {
		return iReporteQuery.obtenerPreguntasReporteUsuario(idReporte, idUsuario);	
	}
		
	@PostMapping("/parcial/{idUsuario}")
	public List<ParcialExtendReporte> getReporteByParcial(@RequestBody List<Integer> idParciales, @PathVariable("idUsuario") int idUsuario) {
		return iReporteQuery.obtenerReportesByParcial(idParciales,idUsuario);
	}
	
	@PostMapping("/guardar/{idUsuario}")
	public boolean guardarRespuestasUsuario(@RequestBody List<PreguntaPrincipalDTO> preguntas, @PathVariable("idUsuario") Integer idUsuario) {
		return iReporteQuery.guardarRespuestasReporte(preguntas, idUsuario);
	}

}
