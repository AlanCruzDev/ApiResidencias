package com.app.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.app.DTO.ModuloPermisosDTO;
import com.app.DTO.ReporteDTO;
import com.app.Entity.Autorizacion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Repository
public class ModuloRepositoryQuery {
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional(readOnly = true)
	public List<ModuloPermisosDTO> obtenerModulosByUsuario(Integer idUsuario){
		Gson gson = new Gson();
		System.out.println("ID Usuario: "+ idUsuario);
		
		String sql ="SELECT idModulo, nombre, JSON_ARRAYAGG(autorizacion) AS Autorizacion	" + 
				"	FROM ( 	" + 
				"    SELECT	" + 
				"        m.idModulo,	" + 
				"        m.nombre,		" + 
				"        (	SELECT		" + 
				"            JSON_OBJECT(		" + 
				"            'id' VALUE a.idAutorizacion,	" + 
				"            'nombre' VALUE a.nombre)       " + 
				"            FROM Autorizacion a			" + 
				"            WHERE a.idAutorizacion = p.idAutorizacion		" + 
				"        ) 	AS autorizacion		" +  
				"    FROM Modulo m		" + 
				"    INNER JOIN PerfilPermisos p ON p.idModulo = m.idModulo		" + 
				"    WHERE p.idUsuario =:idUsuario and p.status = 1		" + 
				"	)		" + 
				"GROUP BY idModulo, nombre		";
		Query q = em.createNativeQuery(sql);
		q.setParameter("idUsuario", idUsuario);
		List<Object[]> data =(List<Object[]>) q.getResultList();
		List<ModuloPermisosDTO> permisosDTOs = new ArrayList<ModuloPermisosDTO>();
		System.out.println("data; "+ data.size());
		
		for(Object[] result: data) {
			ModuloPermisosDTO permisosDTO = new ModuloPermisosDTO();
			permisosDTO.setIdModulo(((BigDecimal) result[0]).intValue());
			permisosDTO.setNombre(result[1].toString());
			String jsonArrayAsString =(String) result[3];
			List<Autorizacion> autorizaciones = gson.fromJson(jsonArrayAsString, new TypeToken<List<Autorizacion>>() {}.getType());
			permisosDTO.setAutorizaciones(autorizaciones);
			permisosDTOs.add(permisosDTO);	
		}
		return permisosDTOs;
		
	}
	
	
	

}
