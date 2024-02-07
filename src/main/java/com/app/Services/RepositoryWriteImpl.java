package com.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.DTO.ParticipantesProyectoDTO;
import com.app.DTO.PreguntaPrincipalDTO;
import com.app.DTO.PreguntasHijasDTO;
import com.app.oracle.IOracleFunciones;


@Repository
public class RepositoryWriteImpl implements IReporteWritw {
	
	
	@Autowired
	private IOracleFunciones oracleFunction;

	@Override
	public boolean guardarRespuestasUsuario(List<PreguntaPrincipalDTO> cuestionario,int idUsuario) {
		try {
			for(int i=0; i<cuestionario.size(); i++) {
				PreguntaPrincipalDTO principalDTO = cuestionario.get(i);
				for(int j=0; j<principalDTO.getHijasDTOs().size(); j++) {
					PreguntasHijasDTO hijasDTO = principalDTO.getHijasDTOs().get(j);	
					if(hijasDTO.getIdTipo().intValue() != 4) {
						int response = oracleFunction.guardar_respuesta_usuario(hijasDTO.getIdPreguntaHija().intValue(), idUsuario, hijasDTO.getRespuestaUsuario());
					}else {
						for(int k=0; k<hijasDTO.getParticipantesProyectos().size(); k++) {
							ParticipantesProyectoDTO proyectoDTO = hijasDTO.getParticipantesProyectos().get(k);
							oracleFunction.guardar_participantes_proyecto(	
									proyectoDTO.getIdParticipanteProyecto().intValue(), 
									proyectoDTO.getNombre(),
									proyectoDTO.getCarrera(), 
									proyectoDTO.getId_Usuario(), 
									proyectoDTO.getIdPreguntaHija());				
						}
					}
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("DATA: "+ e.getMessage());
			
			return false;
		}
		
		return true;
	}
	

}
