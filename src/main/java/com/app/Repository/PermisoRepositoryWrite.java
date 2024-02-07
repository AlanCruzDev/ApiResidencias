package com.app.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PermisoRepositoryWrite {

	@PersistenceContext
	private EntityManager em;
	
	
	public boolean actualizarStatusPermisoByParcial(Long idParcial, Integer idRol) {
		String sql ="UPDATE PERMISOS SET HABILITAR =1 WHERE PERMISOS.IDPARCIAL=:idParcial";
		int filasUpdate = em.createNativeQuery(sql)
				.setParameter("idParcial", idParcial)
				.executeUpdate();
		return filasUpdate > 0;
		
	}
	

}
