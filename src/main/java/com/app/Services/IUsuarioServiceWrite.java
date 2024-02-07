package com.app.Services;

import org.springframework.web.multipart.MultipartFile;

public interface IUsuarioServiceWrite {
	
	public String registrarUsuariosByExcel(MultipartFile file);

}
