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
}
