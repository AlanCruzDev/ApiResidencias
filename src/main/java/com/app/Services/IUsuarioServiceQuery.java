package com.app.Services;

import java.util.List;

import com.app.Entity.Usuario;

public interface IUsuarioServiceQuery {
	public Usuario obtenerUsuarioByName(String username);
	public List<Usuario> obtenerUsuarios();
	public Usuario guardarUsuario(Usuario usuario);
}
