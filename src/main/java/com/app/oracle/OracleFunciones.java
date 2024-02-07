package com.app.oracle;

import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.app.utils.Utilidades;

@Service
public class OracleFunciones implements IOracleFunciones {
	

    @Autowired
    private JdbcTemplate jdbcTemplate;


	@Override
	public int guardar_respuesta_usuario(Integer idPreguntaHija2, Integer Id_Usuario, String respuesta) {
		int response = 0;
		try {
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
					.withFunctionName("guardar_respuesta_usuario")
					.declareParameters(
								new SqlParameter("idPreguntaHija2", Types.INTEGER),
								new SqlParameter("Id_Usuario", Types.INTEGER),
								new SqlParameter("respuesta", Types.VARCHAR));
			SqlParameterSource inParams = new MapSqlParameterSource()
					.addValue("idPreguntaHija2", idPreguntaHija2, Types.INTEGER)
					.addValue("Id_Usuario", Id_Usuario, Types.INTEGER)
					.addValue("respuesta", respuesta, Types.VARCHAR);
			Map<String, Object> result = jdbcCall.execute(inParams);
			response = ((BigDecimal) result.get("return")).intValue();
		}catch(Exception e) {
			System.out.println("errpr darPermsisosByReporte: "+ e.getMessage());
			return 0;
		}
		return  response;
	}


	@Override
	public int guardar_participantes_proyecto(Integer id_Participante_Proyecto, String Nombre_, String carrerA_,
			Integer id_usuario, Integer id_PreguntaHija) {
		int response =0;
		try {
			SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.jdbcTemplate)
					.withFunctionName("guardar_participantes_proyecto")
					.declareParameters(
								new SqlParameter("id_Participante_Proyecto", Types.INTEGER),
								new SqlParameter("Nombre_", Types.VARCHAR),
								new SqlParameter("carrerA_", Types.VARCHAR),
								new SqlParameter("id_usuario", Types.INTEGER),
								new SqlParameter("id_PreguntaHija", Types.INTEGER));
			SqlParameterSource inParams = new MapSqlParameterSource()
					.addValue("id_Participante_Proyecto", id_Participante_Proyecto, Types.INTEGER)
					.addValue("Nombre_", Nombre_, Types.VARCHAR)
					.addValue("carrerA_", carrerA_, Types.VARCHAR)
					.addValue("id_usuario", id_usuario, Types.INTEGER)
					.addValue("id_PreguntaHija", id_PreguntaHija, Types.INTEGER);
			Map<String, Object> result = jdbcCall.execute(inParams);
			response = ((BigDecimal) result.get("return")).intValue();	
		}catch(Exception e){
			System.out.println("errpr darPermsisosByReporte: "+ e.getMessage());
			return 0;
		}
		
		return response;
	}


	@Override
	public String guardarUsuarios(String post_json) {
		String contenidoClob ="";

		System.out.println("Funcion: "+ post_json);
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName("paqueteUsuario")
                .withFunctionName("guardar_usuarios")
                .declareParameters(
                        new SqlParameter("post_json", Types.CLOB));
        
        SqlParameterSource inParams = new MapSqlParameterSource()
        		.addValue("post_json", post_json,Types.CLOB);

        Map<String, Object> result = jdbcCall.execute(inParams);
        
        Clob C = (Clob) result.get("return");
        try {
            contenidoClob = Utilidades.clobToString(C);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR FUNCION guardarUsuarios: "+e);
        }
        return contenidoClob;
	}

}
