package com.app.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.oracle.IOracleFunciones;
import com.app.utils.ExcelProcesador;

@Service
public class UsuarioWriteImpl implements IUsuarioServiceWrite {
	
	
	@Autowired
	private IOracleFunciones oracleFunciones;

	@Override
	public String registrarUsuariosByExcel(MultipartFile file) {
		try {
			String json =ExcelProcesador.ProcessExcel(file.getInputStream());
			String response =oracleFunciones.guardarUsuarios(json);
			return response;
		}catch(IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
