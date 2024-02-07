package com.app.Dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.app.Entity.UsuarioReportes;

public interface IUsuarioReportesDao extends CrudRepository<UsuarioReportes, Long> {
	
	 @Query(value = "SELECT u.IDUSUARIOREPORTES, u.IDUSUARIO, u.IDREPORTE, u.FECHACREACION "
	            + " FROM USUARIOREPORTES u WHERE u.IDUSUARIO = :id_usuario AND u.IDREPORTE = :id_reporte AND u.ESTATUS = 1", nativeQuery = true)
	    UsuarioReportes obtenerReportesCreadosByUsuario(@Param("id_usuario") int id_usuario, @Param("id_reporte") int id_reporte);
	
}
