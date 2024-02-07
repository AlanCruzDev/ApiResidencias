	package com.app.Repository;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.google.gson.reflect.TypeToken;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTO.ParcialExtendReporte;
import com.app.DTO.ParticipantesProyectoDTO;
import com.app.DTO.PreguntaPrincipalDTO;
import com.app.DTO.PreguntasHijasDTO;
import com.app.DTO.ReporteDTO;
import com.app.Entity.ParticipantesProyecto;
import com.app.Entity.PreguntaPrincipal;
import com.app.Entity.PreguntasHijas;
import com.app.utils.Utilidades;
import com.google.gson.Gson;

@Repository
public class ReporteRepositoryQuery {
	
    @PersistenceContext
    private EntityManager em;
    
    
    @Transactional(readOnly = true)
    public List<ParcialExtendReporte> obtenerReportesByParcial(List<Integer> idParcial, int idUsuario) {
    	Gson gson = new Gson();
    	String sql="SELECT\r\n" + 
    			"	p.IDPARCIAL,\r\n" + 
    			"	p.NOMBREPARCIAL ,\r\n" + 
    			"	p.DESCRIPCION,\r\n" + 
    			"	(\r\n" + 
    			"		SELECT\r\n" + 
    			"			JSON_ARRAYAGG(\r\n" + 
    			"				JSON_OBJECT\r\n" + 
    			"					(\r\n" + 
    			"						'IdReporte' VALUE r.IDREPORTE,\r\n" + 
    			"						'NombreReporte' VALUE r.NOMBREREPORTE,\r\n" + 
    			"						'codigo' VALUE r.CODIGO \r\n" + 
    			"					)\r\n" + 
    			"			)\r\n" + 
    			"		FROM  \r\n" + 
    			"			REPORTE r\r\n" + 
    			"		INNER JOIN PERMISOS p2 ON r.IDREPORTE =p2.IDREPORTE AND (p2.IDPARCIAL =p.IDPARCIAL AND p2.HABILITAR = 1  AND r.HABILITADO = 1)  \r\n"
    			+ "		AND r.IDREPORTE NOT IN (SELECT u.IDREPORTE FROM USUARIOREPORTES u WHERE r.IDREPORTE = u.IDREPORTE AND u.IDUSUARIO =:idUsuario AND u.ESTATUS = 1	)		\r\n" + 
    			"	)	\r\n" + 
    			"FROM PARCIAL p \r\n" + 
    			"WHERE P.IDPARCIAL IN :idParcial \r\n	";
    	Query q = em.createNativeQuery(sql);
    	q.setParameter("idParcial", idParcial);
    	q.setParameter("idUsuario", idUsuario); 	
    	List<ParcialExtendReporte>  listaExtender = new ArrayList<ParcialExtendReporte>();
    	
    	List<Object[]> data =(List<Object[]>) q.getResultList();
    	for(Object[] result : data) {
    		ParcialExtendReporte parcialExtendReporte = new ParcialExtendReporte();
    		parcialExtendReporte.setIdParcial(((BigDecimal) result[0]).longValue());
    		parcialExtendReporte.setNombreParcial(result[1].toString());
    		parcialExtendReporte.setDescripcion(result[2].toString());
    		String jsonArrayAsString =(String) result[3];
    		 List<ReporteDTO> reportesList = gson.fromJson(jsonArrayAsString, new TypeToken<List<ReporteDTO>>() {}.getType());
    		 parcialExtendReporte.setReporteDTOs(reportesList);	
    		 listaExtender.add(parcialExtendReporte);
    	}
    	return listaExtender;
    }
    
    @Transactional(readOnly = true)
    public List<PreguntaPrincipalDTO> obtenerCuestionarioByReporteUsuario(Integer idReporte, int idUsuario) {
    	
    	String sql="SELECT \r\n" + 
    			"    p_p.idPreguntaPrincipal,\r\n" + 
    			"    p_p.idReporte,\r\n" + 
    			"    p_p.titulo,\r\n" + 
    			"    p_p.orden,\r\n" + 
    			"    p_p.activo,\r\n" + 
    			"    p_p.saltopagina,\r\n" + 
    			"    (\r\n" + 
    			"        SELECT JSON_ARRAYAGG(\r\n" + 
    			"            JSON_OBJECT(\r\n" + 
    			"                'idPreguntaHija' VALUE p_h.idPreguntasHijas,\r\n" + 
    			"                'pregunta' VALUE p_h.pregunta,\r\n" + 
    			"                'tipo' VALUE p_h.IdTipo,\r\n" + 
    			"                'activo' VALUE p_h.activo,\r\n" + 
    			"                'orden' VALUE p_h.orden,\r\n" +
    			"                'respuestaUsuario' VALUE (SELECT rp.TURESPUESTA  FROM RESPUESTAUSUARIO rp WHERE rp.IDPREGUNTAHIJA=p_h.IDPREGUNTASHIJAS AND rp.IDUSUARIO =:idUsuario)\r\n	" +
    			"            )\r\n" + 
    			"        )\r\n" + 
    			"        FROM PreguntasHijas p_h\r\n" + 
    			"        WHERE p_h.idPreguntaPrincipal = p_p.idPreguntaPrincipal\r\n" + 
    			"    ) AS preguntasHijas\r\n" + 
    			"FROM PreguntasPrincipal p_p \r\n"
    			+ "		WHERE  p_p.IDREPORTE =:idReporte";
    	
    	
    	Query q =em.createNativeQuery(sql);
    	q.setParameter("idUsuario", idUsuario);
    	q.setParameter("idReporte", idReporte);
    	
    	List<Object[]> data =(List<Object[]>) q.getResultList();
    	List<PreguntaPrincipalDTO> preguntasPrincipals = new ArrayList<>();
        Gson gson = new Gson();
        for(Object[] result : data) {
        	PreguntaPrincipalDTO principal = new PreguntaPrincipalDTO();
        	principal.setIdPreguntaPrincipal(((BigDecimal) result[0]).longValue());
            principal.setIdReporte(((BigDecimal) result[1]).intValue());
            principal.setTitulo((String) result[2]);
            principal.setOrden(((BigDecimal) result[3]).intValue());
            principal.setActivo(((BigDecimal) result[4]).intValue());
            principal.setSaltoPagina(((BigDecimal) result[5]).intValue());
            String jsonArrayAsString =(String) result[6];
            List<PreguntasHijasDTO> preguntasHijas1 = gson.fromJson(jsonArrayAsString, new TypeToken<List<PreguntasHijasDTO>>() {}.getType());
            List<PreguntasHijasDTO> response = this.obtenerPreguntasHijasRespuestas(preguntasHijas1,idUsuario);
            principal.setHijasDTOs(response);
            preguntasPrincipals.add(principal);
        }
        return preguntasPrincipals;
    	
    }
    
    private List<PreguntasHijasDTO> obtenerPreguntasHijasRespuestas(List<PreguntasHijasDTO> preguntasHijas1, int idUsuario){
    	List<PreguntasHijasDTO> response = new ArrayList<>();
    	for(int j=0; j<preguntasHijas1.size(); j++) {
        	PreguntasHijasDTO hijasDTO = preguntasHijas1.get(j);
        	if(hijasDTO.getIdTipo() == 4) {
        		List<ParticipantesProyectoDTO> f =obtenerTablaParticipantesProyecto(hijasDTO.getIdPreguntaHija(),idUsuario);
        		hijasDTO.setParticipantesProyectos(f);
        	}
        	response.add(hijasDTO);
        }
    	return response;
    }
    
    @Transactional(readOnly = true)
    public List<ParticipantesProyectoDTO> obtenerTablaParticipantesProyecto(Long idPreguntahija, int idUsuario) {
        try{
            String sql ="SELECT p_p.idParticipanteProyecto, p_p.nombre, p_p.carrera, p_p.id_Usuario, p_p.idPreguntaHija FROM ParticipantesProyecto p_p WHERE p_p.id_Usuario=:idUsuario AND p_p.idPreguntaHija =:idPreguntahija";
            Query q = em.createNativeQuery(sql);
            q.setParameter("idUsuario",idUsuario);
            q.setParameter("idPreguntahija",idPreguntahija);
            List<Object[]> data =(List<Object[]>) q.getResultList();
            List<ParticipantesProyectoDTO> participantesProyectos = new ArrayList<>();
            for(Object[] result : data){
                ParticipantesProyectoDTO proyecto = new ParticipantesProyectoDTO();
                proyecto.setIdParticipanteProyecto(((BigDecimal) result[0]).longValue());
                proyecto.setNombre((String) result[1]);
                proyecto.setCarrera((String) result[2] );
                proyecto.setId_Usuario(((BigDecimal) result[3]).intValue());
                proyecto.setIdPreguntaHija(((BigDecimal) result[4]).intValue());
                participantesProyectos.add(proyecto);
            }
            return participantesProyectos;
        }catch (Exception e){
            System.out.println("ERROR: " + e);
        }
        return null;
    }
    
    

}
