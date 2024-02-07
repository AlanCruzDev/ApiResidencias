package com.app.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.PermisoRepositoryWrite;

@Service
public class PermisosWriteImpl implements IPermisosWrite{
	
	
	@Autowired
	private PermisoRepositoryWrite PermisosWriteImpl;

	@Override
	public boolean habilitarReportes(Long idParcial, Integer idRol) {
		return PermisosWriteImpl.actualizarStatusPermisoByParcial(idParcial, idRol);
	}

}
