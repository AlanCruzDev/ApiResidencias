package com.app.Services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dao.IUsuarioDao;
import com.app.Entity.Usuario;

@Service
public class UsuarioServiceQueryImpl  implements IUsuarioServiceQuery{
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	@Override
	public Usuario obtenerUsuarioByName(String correo) {
		return usuarioDao.findByCorreoInstitucional(correo);
	}


	@Override
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> response = usuarioDao.getUsuarios();
		return response;
	}


	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		if(!Objects.isNull(usuario)) {
			Usuario userExiste=obtenerUsuarioByName(usuario.getCorreoinstitucional());
			if(Objects.isNull(userExiste)) {
				return usuarioDao.save(usuario);
			}
			return usuario;
		}
		return null;
	}


	@Override
	public Usuario logearUsuario(String user, String contra) {
		List<Object[]> resultado = usuarioDao.logeoUsuario(user,contra);
		if(resultado.size() != 0) {
			for(int i=0; i< resultado.size(); i++) {
				Object[] d = resultado.get(i);
				Integer id = ((BigDecimal) d[0]).intValueExact();
		        String nombre = (String) d[1];
		        String matricula = (String) d[2];
		        Usuario usuario = new Usuario();
		        usuario.setId(id);
		        usuario.setNombre(nombre);
		        usuario.setMatricula(matricula);
		        return usuario;
			}
		}
		
		return null;
	}

}
