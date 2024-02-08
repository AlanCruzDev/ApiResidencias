package com.app.Services;

import java.util.List;

import com.app.DTO.ModuloPermisosDTO;

public interface IModuloQuery {

	public List<ModuloPermisosDTO> ObtenerModulosByUsuario(Integer idUsuario);

}
