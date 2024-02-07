package com.app.Services;

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

}
