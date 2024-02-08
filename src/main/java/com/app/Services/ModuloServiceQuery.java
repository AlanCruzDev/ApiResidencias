package com.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.ModuloPermisosDTO;
import com.app.Repository.ModuloRepositoryQuery;


@Service
public class ModuloServiceQuery implements IModuloQuery {
	
	@Autowired
	private ModuloRepositoryQuery moduloRepositoryQuery;

	@Override
	public List<ModuloPermisosDTO> ObtenerModulosByUsuario(Integer idUsuario) {
		return moduloRepositoryQuery.obtenerModulosByUsuario(idUsuario);
	}
	

}
