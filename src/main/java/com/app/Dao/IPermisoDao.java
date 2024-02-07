package com.app.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.Entity.Permisos;

public interface IPermisoDao extends CrudRepository<Permisos, Long>{
	
	
	
	@Query(value = "SELECT p2.IDPARCIAL  FROM PERMISOS p INNER JOIN PARCIAL p2 ON p.IDPARCIAL =p2.IDPARCIAL WHERE p.HABILITAR =1 GROUP BY p2.IDPARCIAL", nativeQuery = true)
	List<Integer> obtenerIdParcialHabilitado();

}
