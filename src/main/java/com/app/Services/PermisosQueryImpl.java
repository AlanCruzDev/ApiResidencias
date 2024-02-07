package com.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.Dao.IPermisoDao;


@Service
public class PermisosQueryImpl implements IPermisosQuery {
	
	@Autowired
	private IPermisoDao permisoDao;
	
	@Override
	public List<Integer> obtenerIdsParciales() {
		return permisoDao.obtenerIdParcialHabilitado();
	}
}
