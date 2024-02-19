package com.app.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.Entity.Usuario;
import com.app.Services.IUsuarioServiceQuery;
import com.app.Services.IUsuarioServiceWrite;
import com.app.utils.ExcelProcesador;

@RestController
@RequestMapping("v1/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioServiceQuery usuarioQueryService;
	
	@Autowired
	private SseController sseController;
	
	
	@Autowired
	private IUsuarioServiceWrite usuarioWrite;
	
	
	@GetMapping(value = "/all")
	public List<Usuario> getAllUsuarios() {
		return usuarioQueryService.obtenerUsuarios();
	}
	
	
	@PostMapping(value = "/save")
	public Usuario guardarUsuario(@RequestBody Usuario user) {
		return usuarioQueryService.guardarUsuario(user);
	}
	
	@PostMapping(value="/registrar")
	public String registrarAlumnosExcel(@RequestParam("file") MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			return "Error: Archivo no seleccionado";
		}
		return usuarioWrite.registrarUsuariosByExcel(file);
	}
	
	@GetMapping("/login/{usuario}/{contra}")
	public ResponseEntity<Usuario> loginUsuario(@PathVariable("usuario") String usuario, @PathVariable("contra")String contra) {
		Usuario user = usuarioQueryService.logearUsuario(usuario, contra);
		 sseController.sendLoginNotification(user);
		 return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	

}
