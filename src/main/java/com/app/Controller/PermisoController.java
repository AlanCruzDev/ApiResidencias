package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.Services.IPermisosQuery;
import com.app.Services.IPermisosWrite;

@RestController
@RequestMapping("v1/permiso")
public class PermisoController {
	
	
	@Autowired
	private IPermisosWrite permisoWrite;
	
	@Autowired
	private IPermisosQuery permisosQuery;
	
	
	
	@PutMapping("/reporte/{idParcial}")
	public boolean habilitarReporte(@PathVariable("idParcial") Long idParcial) {
		return permisoWrite.habilitarReportes(idParcial, 0);
	}
	
	@GetMapping("/parciales_habilitados")
	public List<Integer> obtenerParcialesHabilitados(){
		return permisosQuery.obtenerIdsParciales();
	}
}
