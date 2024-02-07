package com.app.oracle;

public interface IOracleFunciones {
	
	public int guardar_respuesta_usuario(Integer idPreguntaHija2, Integer Id_Usuario, String respuesta);
	public int guardar_participantes_proyecto(Integer id_Participante_Proyecto,
		    String Nombre_,
		    String carrerA_,
		    Integer id_usuario,
		    Integer id_PreguntaHija);
	
	public String guardarUsuarios(String post_json);

}
