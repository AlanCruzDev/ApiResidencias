package com.app.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.app.Entity.Usuario;


public interface IUsuarioDao extends CrudRepository<Usuario,Integer> {
	
	@Query(value = "SELECT id,nombre,apellidopaterno,apellidomaterno,matricula,contrasenia,status,correoinstitucional,primerinicio,edad,fecharegistro FROM Usuario where correoinstitucional='cruzbufer@gmail.com' FETCH FIRST 1 ROWS ONLY",nativeQuery = true)
	Usuario findByCorreoInstitucional(@Param("correo")String correo);
	
	@Query(value="SELECT id,nombre,apellidopaterno,apellidomaterno,matricula,contrasenia,status,correoinstitucional,primerinicio,edad,fecharegistro FROM Usuario", nativeQuery = true)
	List<Usuario> getUsuarios();
	
	@Query(value ="SELECT subquery.id, subquery.nombre, subquery.matricula FROM (SELECT u.id, u.nombre, u.matricula, u.contrasenia FROM Usuario u WHERE u.correoinstitucional = :_usuario AND u.status = 1) subquery WHERE subquery.contrasenia = :_contra", nativeQuery = true)
	List<Object[]> logeoUsuario(@Param("_usuario") String _usuario, @Param("_contra") String _contra); 

	
}
