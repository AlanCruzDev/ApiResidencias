package com.app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import com.app.DTO.UsuarioDTO;

public class ExcelProcesador {
	
	public static String ProcessExcel(InputStream inputStream) {
		
		List<UsuarioDTO> list_usuario = new ArrayList<UsuarioDTO>();
		
		try(Workbook workbook = WorkbookFactory.create(inputStream)) {
			
			Sheet sheet = workbook.getSheetAt(0); // obtener la primera hoja del excel
			for(Row row: sheet) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				for(Cell cell:row) {
					if(cell.getRowIndex() != 0) {
						String cellValue = getCellValueAsString(cell);
						usuarioDTO=crearObjectData(cellValue, cell.getColumnIndex(), usuarioDTO);
					}	
				}
				list_usuario.add(usuarioDTO);
				System.out.println();
			}
			
			String json =Utilidades.convertEntityJson(list_usuario);
			return json;
		}catch(IOException e) {
			e.printStackTrace();
			return "";
		}
				
	}
	
	private static UsuarioDTO crearObjectData(String value, int celda, UsuarioDTO usuarioDTO) {
		
		switch(celda) {
		case 0:
			usuarioDTO.setNombre(value);
			break;
		case 1:
			usuarioDTO.setApellidoPaterno(value);
			break;
		case 2:
			usuarioDTO.setApellidoMaterno(value);
			break;
		case 3:
			usuarioDTO.setMatricula(value);
			break;
		case 4:
			usuarioDTO.setCorreoInstitucional(value);
			break;
		case 5:
			usuarioDTO.setEdad(value);
			break;
		}
		return usuarioDTO;
	}
	
	private static String getCellValueAsString(Cell cell) {
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue();
	        case NUMERIC:
	            if (cell.getNumericCellValue() == (long) cell.getNumericCellValue()) {
	                return String.valueOf((long) cell.getNumericCellValue());
	            } else {
	                return String.valueOf(cell.getNumericCellValue());
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        default:
	            return "";
	    }
	}


}
