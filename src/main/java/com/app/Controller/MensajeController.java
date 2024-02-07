package com.app.Controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {
	
	
	@MessageMapping("/chat/{roomId}")
	@SendTo("/topic/{roomId}")
	public String Saludo(@DestinationVariable String roomId) {
		 System.out.println(roomId); 
		return "Hola Mundo";
	}
}
