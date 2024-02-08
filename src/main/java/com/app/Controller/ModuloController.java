package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.ModuloPermisosDTO;
import com.app.Services.IModuloQuery;

@RestController
@RequestMapping("v1/modulo")
public class ModuloController {
	
	@Autowired
	private IModuloQuery moduloQuery;
	
	
	@GetMapping("/modulo/usuario/{idUsuario}")
	public List<ModuloPermisosDTO> obtenerModuloUsuario(@PathVariable("idUsuario")Integer idUsuario){
		return moduloQuery.ObtenerModulosByUsuario(idUsuario);
	}

}
